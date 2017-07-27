package com.it355.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it355.entities.Korisnik;
import com.it355.service.KorsinikService;

@Controller
public class RegisterController {

	@Autowired
	private KorsinikService korisnikService;

	@RequestMapping("/register")
	public String register(Model model) {
		Korisnik korisnik = new Korisnik();

		model.addAttribute("korisnik", korisnik);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result,
			Model model) {

		System.err.println("Korisnik u kontroleru: " + korisnik);
		if (result.hasErrors()) {
			System.err.println("Ima gresaka.");
			System.err.println("Broj gresaka: " + result.getAllErrors().get(0).toString());
			return "register";
		}

		List<Korisnik> listaKorsinika = korisnikService.getListaSvihKorisnika();

		System.err.println("Lista korisnika: " + listaKorsinika);
		for (int i = 0; i < listaKorsinika.size(); i++) {
			if (korisnik.getEmail().equals(listaKorsinika.get(i).getEmail())) {
				model.addAttribute("emailMsg", "Email koji ste uneli vec postoji.");

				return "register";
			}

			if (korisnik.getUsername().equals(listaKorsinika.get(i).getUsername())) {
				model.addAttribute("usernameMsg", "Username koji ste uneli vec postoji.");

				return "register";
			}
		}
		korisnikService.addKorisnik(korisnik);

		return "registerSuccess";
	}
}
