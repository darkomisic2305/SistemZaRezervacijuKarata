package com.it355.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it355.dao.FilmDao;
import com.it355.entities.Film;
import com.it355.entities.Projekcija;

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

	@Override
	public void addFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(film);
	}

	@Override
	public Film getFilmById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Film)session.createCriteria(Film.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Projekcija> getSveProjekcijeZaFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Projekcija> projekcije = session.createCriteria(Projekcija.class).add(Restrictions.eq("film", film)).list(); 
		
		System.err.println("Projekcije: " + projekcije);
		
		return projekcije;
	}

	@Override
	public void editFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(film);
		session.flush();
	}

	@Override
	public void deleteFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(film);
		session.flush();
	}

}
