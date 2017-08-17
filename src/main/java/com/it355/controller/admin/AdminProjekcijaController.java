package com.it355.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it355.entities.Film;
import com.it355.entities.Projekcija;
import com.it355.entities.Sala;
import com.it355.service.FilmService;
import com.it355.service.ProjekcijaService;
import com.it355.service.SalaService;

@Controller
@RequestMapping("/admin/projekcija")
public class AdminProjekcijaController {

	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private SalaService salaService;
	
	@RequestMapping("/sveProjekcije")
	public String projekcije(Model model) {
		System.err.println("Usao u metodu projekcije");
		List<Projekcija> projekcije = projekcijaService.getListaSvihProjekcija();
		
		model.addAttribute("projekcije", projekcije);
		
		return "projekcije";
	}

	@RequestMapping("/addProjekcija")
	public String addProjekcija(Model model) {
		Projekcija projekcija = new Projekcija();
		
		List<Film> filmovi = filmService.getListaSvihFilmova();
		List<Sala> sale = salaService.getListaSvihSala();
	
		model.addAttribute("projekcija", projekcija);
		model.addAttribute("filmovi", filmovi);
		model.addAttribute("sale", sale);
		
		return "addProjekcija";
	}

	@RequestMapping(value = "/addProjekcija", method = RequestMethod.POST)
	public String addProjekcijaPost(@Valid @ModelAttribute("projekcija") Projekcija projekcija, BindingResult result, Model model, 
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProjekcija";
		}
				
		projekcija.setSlobodnoSedista(projekcija.getSala().getBrojSedista());
		projekcijaService.addProjekcija(projekcija);

		return "redirect:/admin/projekcija/sveProjekcije";
	}

	@RequestMapping("/editProjekcija/{id}")
	public String editProjekcija(@PathVariable("id") int id, Model model) {
		Projekcija projekcija = projekcijaService.getProjekcijaById(id);

		List<Film> filmovi = filmService.getListaSvihFilmova();
		List<Sala> sale = salaService.getListaSvihSala();
	
		model.addAttribute("projekcija", projekcija);
		model.addAttribute("filmovi", filmovi);
		model.addAttribute("sale", sale);

		return "editProjekcija";
	}

	@RequestMapping(value = "/editProjekcija", method = RequestMethod.POST)
	public String editProjekcijaPost(@Valid @ModelAttribute("projekcija") Projekcija projekcija, BindingResult result, 
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProjekcija";
		}
		
		projekcija.setSlobodnoSedista(projekcija.getSala().getBrojSedista());
		
		projekcijaService.editProjekcija(projekcija);

		return "redirect:/admin/projekcija/sveProjekcije";
	}

	@RequestMapping("/deleteProjekcija/{id}")
	public String deleteProjekcija(@PathVariable int id, Model model, HttpServletRequest request) {
		Projekcija projekcija = projekcijaService.getProjekcijaById(id);
		projekcijaService.deleteProjekcija(projekcija);

		return "redirect:/admin/projekcija/sveProjekcije";
	}
}
