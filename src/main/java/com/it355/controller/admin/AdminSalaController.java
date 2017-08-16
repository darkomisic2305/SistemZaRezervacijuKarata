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

import com.it355.entities.Sala;
import com.it355.service.SalaService;

@Controller
@RequestMapping("/admin/sala")
public class AdminSalaController {

	@Autowired
	private SalaService salaService;
	
	
	@RequestMapping("/sveSale")
	public String sale(Model model) {
		List<Sala> sale = salaService.getListaSvihSala();
		
		model.addAttribute("sale", sale);
		
		return "sale";
	}

	@RequestMapping("/addSala")
	public String addSala(Model model) {
		Sala sala = new Sala();

		model.addAttribute("sala", sala);

		return "addSala";
	}

	@RequestMapping(value = "/addSala", method = RequestMethod.POST)
	public String addSalaPost(@Valid @ModelAttribute("sala") Sala sala, BindingResult result, Model model, 
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addSala";
		}
		
		salaService.addSala(sala);

		return "redirect:/admin/sala/sveSale";
	}

	@RequestMapping("/editSala/{id}")
	public String editSala(@PathVariable("id") int id, Model model) {
		Sala sala = salaService.getSalaById(id);

		model.addAttribute("sala", sala);

		return "editSala";
	}

	@RequestMapping(value = "/editSala", method = RequestMethod.POST)
	public String editSalaPost(@Valid @ModelAttribute("sala") Sala sala, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editSala";
		}

		salaService.editSala(sala);

		return "redirect:/admin/sala/sveSale";
	}

	@RequestMapping("/deleteSala/{id}")
	public String deleteSala(@PathVariable int id, Model model, HttpServletRequest request) {
		Sala sala = salaService.getSalaById(id);
		salaService.deleteSala(sala);

		return "redirect:/admin/sala/sveSale";
	}
}
