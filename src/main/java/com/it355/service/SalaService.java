package com.it355.service;

import java.util.List;

import com.it355.entities.Sala;

public interface SalaService {

	public List<Sala> getListaSvihSala();
	public void addSala(Sala sala);
	public Sala getSalaById(int id);
	public void editSala(Sala sala);
	public void deleteSala(Sala sala);
}
