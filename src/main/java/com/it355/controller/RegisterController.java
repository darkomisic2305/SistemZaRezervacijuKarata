package com.it355.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it355.entities.Korisnik;
import com.it355.entities.data.Pol;
import com.it355.service.KorsinikService;
import com.it355.service.MailService;

import javassist.compiler.SyntaxError;

@Controller
public class RegisterController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private KorsinikService korisnikService;
	
	@Autowired
	private MailService mailService;

	@RequestMapping("/register")
	public String register(Model model, Locale locale, HttpServletRequest request) {
	
		if(request.isUserInRole("ROLE_ADMIN")) {
			System.err.println("ROLA ADMIN");
		} else if(request.isUserInRole("ROLE_USER")){
			System.err.println("ROLA USER");
		} else {
			System.err.println("ROLA NIJE");
		}
		
		/*if(request.getUserPrincipal() != null) {
			return "home";
		}*/
		
		Korisnik korisnik = new Korisnik();
		List<String> polovi = new ArrayList<String>();
		polovi.add(messageSource.getMessage("muski", new Object[] {}, locale));
		polovi.add(messageSource.getMessage("zenski", new Object[] {}, locale));
		
		model.addAttribute("korisnik", korisnik);
		model.addAttribute("polovi", polovi);
		
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result,
			Model model, Locale locale) {

		if (result.hasErrors()) {
			return "register";
		}

		List<Korisnik> listaKorsinika = korisnikService.getListaSvihKorisnika();

		System.err.println("Lista korisnika: " + listaKorsinika);
		for (int i = 0; i < listaKorsinika.size(); i++) {
			if (korisnik.getEmail().equals(listaKorsinika.get(i).getEmail())) {
				model.addAttribute("emailMsg", messageSource.getMessage("emailMsg", new Object[] {}, locale));

				return "register";
			}

			if (korisnik.getUsername().equals(listaKorsinika.get(i).getUsername())) {
				model.addAttribute("usernameMsg", messageSource.getMessage("usernameMsg", new Object[] {}, locale));

				return "register";
			}
		}
		
		if(locale.getLanguage().equals("en")) {
			if(korisnik.getPol().equals("Male")) {
				korisnik.setPol("Muški");
			} else {
				korisnik.setPol("Ženski");
			}
			
		}
		korisnikService.addKorisnik(korisnik);
		
		mailService.sendRegisterEMail(korisnik, locale);
		
		return "registerSuccess";
	}
}
