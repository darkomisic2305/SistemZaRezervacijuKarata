package com.it355.dao;

import com.it355.entities.Rezervacija;

public interface RezervacijaDao {
	
	public Rezervacija getRezervacijaById(int id);
	public void deleteRezervacija(Rezervacija rezervacija);
}
