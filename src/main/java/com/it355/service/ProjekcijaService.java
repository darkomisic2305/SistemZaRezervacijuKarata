package com.it355.service;

import java.util.List;

import com.it355.entities.Projekcija;
import com.it355.entities.Rezervacija;

public interface ProjekcijaService {

	public List<Projekcija> getListaSvihProjekcija();
	public void addProjekcija(Projekcija projekcija);
	public Projekcija getProjekcijaById(int id);
	public void editProjekcija(Projekcija projekcija);
	public void deleteProjekcija(Projekcija projekcija);
	public List<Rezervacija> getSveRezervacijeZaProjekciju(Projekcija projekcija);
}
