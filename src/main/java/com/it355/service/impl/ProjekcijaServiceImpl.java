package com.it355.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.ProjekcijaDao;
import com.it355.entities.Projekcija;
import com.it355.service.ProjekcijaService;

@Service
public class ProjekcijaServiceImpl implements ProjekcijaService {

	@Autowired
	private ProjekcijaDao projekcijaDao;
	
	@Override
	public List<Projekcija> getListaSvihProjekcija() {
		return projekcijaDao.getListaSvihProjekcija();
	}

	@Override
	public void addProjekcija(Projekcija projekcija) {
		projekcijaDao.addProjekcija(projekcija);
	}

	@Override
	public Projekcija getProjekcijaById(int id) {
		return projekcijaDao.getProjekcijaById(id);
	}

	@Override
	public void editProjekcija(Projekcija projekcija) {
		projekcijaDao.editProjekcija(projekcija);
	}

	@Override
	public void deleteProjekcija(Projekcija projekcija) {
		projekcijaDao.deleteProjekcija(projekcija);
	}
}
