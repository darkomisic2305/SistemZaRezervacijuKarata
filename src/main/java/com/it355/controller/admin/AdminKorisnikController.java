package com.it355.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it355.entities.Korisnik;
import com.it355.entities.Projekcija;
import com.it355.service.KorsinikService;

@Controller
@RequestMapping("/admin/korisnik")
public class AdminKorisnikController {

	@Autowired
	private KorsinikService korisnikService;
	
	@RequestMapping("/sviKorisnici")
	public String korisnici(Model model) {
		List<Korisnik> korisnici = korisnikService.getListaSvihKorisnika();
		
		model.addAttribute("korisnici", korisnici);
		
		return "korisnici";
	}
	
	@RequestMapping("/deleteKorisnik/{username}")
	public String deleteKorisnik(@PathVariable String username, Model model, HttpServletRequest request) {
		System.err.println("Usao u metodu deleteKorisnik.");
		System.err.println("Username je " + username);
		Korisnik korisnik = korisnikService.getKorsinikByUsername(username);
		korisnikService.deleteKorisnik(korisnik);

		return "redirect:/admin/korisnik/sviKorisnici";
	}
	
	
}
