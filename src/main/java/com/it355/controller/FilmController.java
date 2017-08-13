package com.it355.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it355.entities.Film;
import com.it355.entities.Projekcija;
import com.it355.service.FilmService;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@RequestMapping("/film/{id}")
	public String film(@PathVariable(value = "id") int id, Model model) {
		Film film = filmService.getFilmById(id);
		
		List<Projekcija> projekcije = filmService.getSveProjekcijeZaFilm(film);
		
		model.addAttribute("film", film);
		model.addAttribute("projekcije", projekcije);
		
		return "film";
	}
}
