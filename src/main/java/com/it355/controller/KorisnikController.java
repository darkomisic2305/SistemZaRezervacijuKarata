package com.it355.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;
import com.it355.service.KorisnikService;

@Controller
@RequestMapping("/user")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping("/profile/{username}")
	public String profile(@PathVariable(value = "username")String username, Model model, HttpServletRequest request) {
		if(!request.getUserPrincipal().getName().equals(username)) {
			return "home";
		}
		Korisnik korisnik = korisnikService.getKorsinikByUsername(username);
		
		List<Rezervacija> rezervacije = korisnikService.getListaRezervacijaPoKorisniku(korisnik);
		
		model.addAttribute("korisnik", korisnik);
		model.addAttribute("rezervacije", rezervacije);
		
		return "profile";
	}
}
