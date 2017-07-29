package com.it355.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it355.dao.FilmDao;
import com.it355.entities.Film;

@Repository
@Transactional
public class FilmDaoImpl implements FilmDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Film> getListaSvihFilmova() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Film.class).list();
	}

}
