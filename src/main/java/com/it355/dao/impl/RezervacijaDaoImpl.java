package com.it355.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it355.dao.RezervacijaDao;
import com.it355.entities.Projekcija;
import com.it355.entities.Rezervacija;

@Repository
@Transactional
public class RezervacijaDaoImpl implements RezervacijaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void deleteRezervacija(Rezervacija rezervacija) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(rezervacija);
		session.flush();
	}

	@Override
	public Rezervacija getRezervacijaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Rezervacija)session.createCriteria(Rezervacija.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	
}
