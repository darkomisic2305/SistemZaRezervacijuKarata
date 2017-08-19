package com.it355.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it355.dao.ProjekcijaDao;
import com.it355.entities.Projekcija;
import com.it355.entities.Rezervacija;

@Repository
@Transactional
public class ProjekcijaDaoImpl implements ProjekcijaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Projekcija> getListaSvihProjekcija() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Projekcija.class).list();
	}

	@Override
	public void addProjekcija(Projekcija projekcija) {
		Session session = sessionFactory.getCurrentSession();

		session.save(projekcija);
	}

	@Override
	public Projekcija getProjekcijaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Projekcija)session.createCriteria(Projekcija.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void editProjekcija(Projekcija projekcija) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projekcija);
		session.flush();
	}

	@Override
	public void deleteProjekcija(Projekcija projekcija) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(projekcija);
		session.flush();
	}

	@Override
	public List<Rezervacija> getSveRezervacijeZaProjekciju(Projekcija projekcija) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Rezervacija.class).add(Restrictions.eq("projekcija", projekcija)).list();
	}
}
