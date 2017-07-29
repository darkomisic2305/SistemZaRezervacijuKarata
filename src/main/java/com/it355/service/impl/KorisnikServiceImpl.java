package com.it355.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.KorisnikDao;
import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;
import com.it355.service.KorsinikService;

@Service
public class KorisnikServiceImpl implements KorsinikService {

	@Autowired
	private KorisnikDao korisnikDao;

	@Override
	public void addKorisnik(Korisnik korisnik) {
		korisnikDao.addKorisnik(korisnik);
	}

	@Override
	public List<Korisnik> getListaSvihKorisnika() {
		return korisnikDao.getListaSvihKorisnika();
	}

	@Override
	public Korisnik getKorsinikById(int id) {
		return korisnikDao.getKorsinikById(id);
	}

	@Override
	public Korisnik getKorsinikByUsername(String username) {
		return korisnikDao.getKorsinikByUsername(username);
	}

	@Override
	public List<Rezervacija> getListaRezervacijaPoKorisniku(Korisnik korisnik) {
		return korisnikDao.getListaRezervacijaPoKorisniku(korisnik);
	}

}
