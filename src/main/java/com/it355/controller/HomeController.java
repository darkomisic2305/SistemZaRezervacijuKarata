package com.it355.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it355.entities.Film;
import com.it355.entities.Korisnik;
import com.it355.entities.data.Tehnologija;
import com.it355.service.FilmService;
import com.it355.service.MailService;

@Controller
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private FilmService filmService;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Film> filmovi = filmService.getListaSvihFilmova();
		model.addAttribute("filmovi", filmovi);
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, Locale locale, HttpServletRequest request) {
		if(request.getUserPrincipal() != null) {
			return "home";
		}
		
		if(error != null) {
			model.addAttribute("error", messageSource.getMessage("pogresniPodaci", new Object[] {}, locale));
		}
		
		if(logout != null) {
			model.addAttribute("msg", messageSource.getMessage("uspesanLogout", new Object[] {}, locale));
		}
		
		return "login";
	}

	
}
