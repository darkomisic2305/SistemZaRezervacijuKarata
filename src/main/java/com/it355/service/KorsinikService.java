package com.it355.service;

import java.util.List;

import com.it355.entities.Korisnik;

public interface KorsinikService {

	public void addKorisnik(Korisnik korisnik);
	public List<Korisnik> getListaSvihKorisnika();
	public Korisnik getKorsinikById(int id);
}
