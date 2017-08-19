package com.it355.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.RezervacijaDao;
import com.it355.entities.Rezervacija;
import com.it355.service.RezervacijaService;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {

	@Autowired
	private RezervacijaDao rezervacijaDao;
	
	@Override
	public void deleteRezervacija(Rezervacija rezervacija) {
		rezervacijaDao.deleteRezervacija(rezervacija);
	}

	@Override
	public Rezervacija getRezervacijaById(int id) {
		return rezervacijaDao.getRezervacijaById(id);
	}
}
