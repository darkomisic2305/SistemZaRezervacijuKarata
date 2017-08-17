package com.it355.dao;

import java.util.List;

import com.it355.entities.Projekcija;

public interface ProjekcijaDao {
	
	public List<Projekcija> getListaSvihProjekcija();
	public void addProjekcija(Projekcija projekcija);
	public Projekcija getProjekcijaById(int id);
	public void editProjekcija(Projekcija projekcija);
	public void deleteProjekcija(Projekcija projekcija);
}
