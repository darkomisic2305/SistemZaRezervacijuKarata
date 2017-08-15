package com.it355.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import com.it355.dao.SalaDao;
import com.it355.entities.Sala;

@Repository
@Transactional
public class SalaDaoImpl implements SalaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Sala> getListaSvihSala() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Sala.class).list();
	}

	@Override
	public void addSala(Sala sala) {
		Session session = sessionFactory.getCurrentSession();

		session.save(sala);
	}

	@Override
	public Sala getSalaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Sala)session.createCriteria(Sala.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void editSala(Sala sala) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sala);
		session.flush();
	}

	@Override
	public void deleteSala(Sala sala) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(sala);
		session.flush();
	}

}
