package com.it355.service;

import com.it355.entities.Rezervacija;

public interface RezervacijaService {

	public Rezervacija getRezervacijaById(int id);
	public void deleteRezervacija(Rezervacija rezervacija);

}
