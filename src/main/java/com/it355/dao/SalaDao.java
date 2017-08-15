package com.it355.dao;

import java.util.List;

import com.it355.entities.Sala;

public interface SalaDao {

	public List<Sala> getListaSvihSala();
	public void addSala(Sala sala);
	public Sala getSalaById(int id);
	public void editSala(Sala sala);
	public void deleteSala(Sala sala);
}
