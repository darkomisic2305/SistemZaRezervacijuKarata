package com.it355.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.it355.entities.Film;
import com.it355.service.FilmService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private Path path;
	
	@Autowired
	private FilmService filmService;

	@RequestMapping("/addFilm")
	public String addFilm(Model model) {
		Film film = new Film();
		
		model.addAttribute("film", film);
		
		return "addFilm";
	}
	
	@RequestMapping(value = "/addFilm", method = RequestMethod.POST)
	public String addFilmPost(@Valid @ModelAttribute("film") Film film, Model model, BindingResult result,
			HttpServletRequest request) {
		
		
		if(result.hasErrors()) {
			return "addFilm";
		}
		
		filmService.addFilm(film);
		
		MultipartFile slika = film.getSlika();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + film.getId() + ".png");
		
		if(slika != null && !slika.isEmpty()) {
			try {
				slika.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Slika nije sacuvana.", e);
			}
		}
		
		
		
		return "redirect:/";
	}
}
