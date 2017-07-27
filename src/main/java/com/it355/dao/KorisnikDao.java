package com.it355.dao;

import java.util.List;

import com.it355.entities.Korisnik;

public interface KorisnikDao {
	
	public void addKorisnik(Korisnik korisnik);
	public List<Korisnik> getListaSvihKorisnika();
	public Korisnik getKorsinikById(int id);
}
