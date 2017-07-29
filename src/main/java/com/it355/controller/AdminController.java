package com.it355.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it355.entities.Film;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/addFilm")
	public String addFilm(Model model) {
		Film film = new Film();
		
		model.addAttribute("film", film);
		
		return "addFilm";
	}
	
	/*@RequestMapping(value = "/addFilm", method = RequestMethod.POST)
	public String addFilmPost(@Valid @ModelAttribute("film") Film film, Model model) {
		
		filmService.addFilm(film);
		
		return "addFilm";
	}*/
}
