package com.it355.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.multipart.MultipartFile;

import com.it355.entities.Film;
import com.it355.service.FilmService;

@Controller
@RequestMapping("/admin/film")
public class AdminFilmController {

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

		if (result.hasErrors()) {
			return "addFilm";
		}

		filmService.addFilm(film);

		MultipartFile slika = film.getSlika();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + film.getId() + ".png");

		if (slika != null && !slika.isEmpty()) {
			try {
				slika.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Slika nije sacuvana.", e);
			}
		}

		return "redirect:/";
	}

	@RequestMapping("/editFilm/{id}")
	public String editFilm(@PathVariable("id") int id, Model model) {
		Film film = filmService.getFilmById(id);

		model.addAttribute("film", film);

		return "editFilm";
	}

	@RequestMapping(value = "/editFilm", method = RequestMethod.POST)
	public String editFilmPost(@Valid @ModelAttribute("film") Film film, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editFilm";
		}

		MultipartFile slika = film.getSlika();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + film.getId() + ".png");

		if (slika != null && !slika.isEmpty()) {
			try {
				slika.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Slika nije sacuvana.", e);
			}
		}

		filmService.editFilm(film);

		return "redirect:/";
	}

	@RequestMapping("/deleteFilm/{id}")
	public String deleteFilm(@PathVariable int id, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Film film = filmService.getFilmById(id);
		filmService.deleteFilm(film);

		return "redirect:/";
	}
}
