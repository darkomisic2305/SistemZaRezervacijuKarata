package com.it355.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	private MailService mailService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	/*
	@RequestMapping("/sendMail")
	public String sendMail() {
		mailService.sendMail("darkomisic94@gmail.com", "test", "testiranje");
		return "redirect:/";
	}*/
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error != null) {
			model.addAttribute("error", "Invalid username and/or password.");
		}
		
		if(logout != null) {
			model.addAttribute("msg", "You have been logged out successfully.");
		}
		
		return "login";
	}

	
}
