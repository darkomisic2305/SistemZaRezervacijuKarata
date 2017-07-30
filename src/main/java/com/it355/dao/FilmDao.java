package com.it355.dao;

import java.util.List;

import com.it355.entities.Film;

public interface FilmDao {

	public List<Film> getListaSvihFilmova();
	public void addFilm(Film film);
}
