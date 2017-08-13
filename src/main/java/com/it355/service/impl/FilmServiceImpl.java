package com.it355.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.FilmDao;
import com.it355.entities.Film;
import com.it355.entities.Projekcija;
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

	@Override
	public Film getFilmById(int id) {
		return filmDao.getFilmById(id);
	}

	@Override
	public List<Projekcija> getSveProjekcijeZaFilm(Film film) {
		return filmDao.getSveProjekcijeZaFilm(film);
	}

	@Override
	public void editFilm(Film film) {
		filmDao.editFilm(film);
	}

	@Override
	public void deleteFilm(Film film) {
		filmDao.deleteFilm(film);
	}

}
