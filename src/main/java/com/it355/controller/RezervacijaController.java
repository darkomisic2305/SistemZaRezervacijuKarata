package com.it355.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it355.entities.Korisnik;
import com.it355.entities.Projekcija;
import com.it355.entities.Rezervacija;
import com.it355.service.ProjekcijaService;
import com.it355.service.RezervacijaService;
import com.it355.service.KorisnikService;
import com.it355.service.MailService;

@Controller
public class RezervacijaController {

	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/rezervacija/{projekcijaId}")
	public String rezervacija(@PathVariable int projekcijaId, Model model, HttpServletRequest request) {
		Projekcija projekcija = projekcijaService.getProjekcijaById(projekcijaId);
		Korisnik korisnik = korisnikService.getKorsinikByUsername(request.getUserPrincipal().getName());
		
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setProjekcija(projekcija);
		rezervacija.setKorisnik(korisnik);
		System.err.println("REZERVACIJA GET: " + rezervacija);
		model.addAttribute("rezervacija", rezervacija);
		
		return "rezervacija";
	}
	
	@RequestMapping(value = "/rezervacija/{projekcijaId}", method = RequestMethod.POST)
	public String rezervacijaPost(@Valid @ModelAttribute("rezervacija") Rezervacija rezervacija, BindingResult result,
			Model model, Locale locale, @PathVariable int projekcijaId, HttpServletRequest request) {
		Projekcija projekcija = projekcijaService.getProjekcijaById(projekcijaId);
		Korisnik korisnik = korisnikService.getKorsinikByUsername(request.getUserPrincipal().getName());
		
		if (result.hasErrors()) {
			return "rezervacija";
		}
		
		rezervacija.setProjekcija(projekcija);
		rezervacija.setKorisnik(korisnik);
				
		if (rezervacija.getBrojKarata() > rezervacija.getProjekcija().getSlobodnoSedista()) {
			model.addAttribute("nemaMestaMsg", messageSource.getMessage("nemaMestaMsg", new Object[] {}, locale));
			return "rezervacija";
		}

		rezervacijaService.addRezervacija(rezervacija);
		rezervacija.getProjekcija().setSlobodnoSedista(rezervacija.getProjekcija().getSlobodnoSedista()-rezervacija.getBrojKarata());
		projekcijaService.editProjekcija(rezervacija.getProjekcija());
		
		mailService.sendReservationEMail(rezervacija, locale);
		
		return "uspesnaRezervacija";
	}
}
