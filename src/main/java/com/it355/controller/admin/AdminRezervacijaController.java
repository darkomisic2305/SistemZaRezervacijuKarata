package com.it355.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it355.entities.Rezervacija;
import com.it355.service.ProjekcijaService;
import com.it355.service.RezervacijaService;

@Controller
@RequestMapping("/admin/rezervacija")
public class AdminRezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@RequestMapping("/deleteRezervacija/{id}")
	public String deleteRezervacija(@PathVariable int id, Model model, HttpServletRequest request) {
		Rezervacija rezervacija = rezervacijaService.getRezervacijaById(id);
		rezervacijaService.deleteRezervacija(rezervacija);
		
		rezervacija.getProjekcija().setSlobodnoSedista(rezervacija.getProjekcija().getSlobodnoSedista()+rezervacija.getBrojKarata());
		
		projekcijaService.editProjekcija(rezervacija.getProjekcija());

		return "redirect:/admin/projekcija/spisakRezervacija/" + rezervacija.getProjekcija().getId();
	}
	
}
