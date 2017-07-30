package com.it355.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.FilmDao;
import com.it355.entities.Film;
import com.it355.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	
	@Override
	public List<Film> getListaSvihFilmova() {
		return filmDao.getListaSvihFilmova();
	}

	@Override
	public void addFilm(Film film) {
		filmDao.addFilm(film);
	}

}
