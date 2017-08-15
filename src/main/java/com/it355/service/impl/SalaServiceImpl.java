package com.it355.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it355.dao.SalaDao;
import com.it355.entities.Sala;
import com.it355.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaDao salaDao;
	
	@Override
	public List<Sala> getListaSvihSala() {
		return salaDao.getListaSvihSala();
	}

	@Override
	public void addSala(Sala sala) {
		salaDao.addSala(sala);
	}

	@Override
	public Sala getSalaById(int id) {
		return salaDao.getSalaById(id);
	}

	@Override
	public void editSala(Sala sala) {
		salaDao.editSala(sala);
	}

	@Override
	public void deleteSala(Sala sala) {
		salaDao.deleteSala(sala);
	}

}
