package com.it355.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.it355.entities.Film;
import com.it355.service.FilmService;

@Component
public class IntegerToFilm implements Converter<String, Film> {

	@Autowired
	private FilmService filmService;
	
	@Override
	public Film convert(String s) {
		if(s.isEmpty()) {
			return null;
		}
		Integer value = Integer.valueOf(s);
		System.err.println("Konvertovanje u film!");
		Film film = filmService.getFilmById(value);
		return film;
	}

}
