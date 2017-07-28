package com.it355.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it355.entities.Korisnik;
import com.it355.entities.data.Tehnologija;
import com.it355.service.MailService;

@Controller
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, Locale locale) {
		if(error != null) {
			model.addAttribute("error", messageSource.getMessage("pogresniPodaci", new Object[] {}, locale));
		}
		
		if(logout != null) {
			model.addAttribute("msg", messageSource.getMessage("uspesanLogout", new Object[] {}, locale));
		}
		
		return "login";
	}

	
}
