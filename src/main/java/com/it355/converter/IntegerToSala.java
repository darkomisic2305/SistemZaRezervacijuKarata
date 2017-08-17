package com.it355.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.it355.entities.Film;
import com.it355.entities.Sala;
import com.it355.service.FilmService;
import com.it355.service.SalaService;

@Component
public class IntegerToSala implements Converter<String, Sala> {

	@Autowired
	private SalaService salaService;
	
	@Override
	public Sala convert(String s) {
		if(s.isEmpty()) {
			return null;
		}
		Integer value = Integer.valueOf(s);
		System.err.println("Konvertovanje u salu!");
		Sala sala = salaService.getSalaById(value);
		return sala;
	}

}
