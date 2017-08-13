package com.it355.dao;

import java.util.List;

import com.it355.entities.Film;
import com.it355.entities.Projekcija;

public interface FilmDao {

	public List<Film> getListaSvihFilmova();
	public void addFilm(Film film);
	public Film getFilmById(int id);
	public List<Projekcija> getSveProjekcijeZaFilm(Film film);
	public void editFilm(Film film);
	public void deleteFilm(Film film);
}
