package com.it355.service;

import java.util.List;

import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;

public interface KorsinikService {

	public void addKorisnik(Korisnik korisnik);
	public List<Korisnik> getListaSvihKorisnika();
	public Korisnik getKorsinikById(int id);
	public Korisnik getKorsinikByUsername(String username);
	public List<Rezervacija> getListaRezervacijaPoKorisniku(Korisnik korisnik);
}
