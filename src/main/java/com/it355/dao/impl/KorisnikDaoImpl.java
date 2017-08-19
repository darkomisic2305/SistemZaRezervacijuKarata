package com.it355.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it355.dao.KorisnikDao;
import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;
import com.it355.entities.User;
import com.it355.entities.UserRole;
import com.it355.service.MailService;

@Repository
@Transactional
public class KorisnikDaoImpl implements KorisnikDao {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public void addKorisnik(Korisnik korisnik) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(korisnik);
		
		User user = new User();
		user.setUsername(korisnik.getUsername());
		user.setPassword(korisnik.getPassword());
		user.setEnabled(true);
		
		UserRole userRole = new UserRole();
		userRole.setUsername(korisnik.getUsername());
		userRole.setRole("ROLE_USER");

		session.save(user);
		session.save(userRole);
		
		session.flush();
	}

	@Override
	public List<Korisnik> getListaSvihKorisnika() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Korisnik.class).list();
	}

	@Override
	public Korisnik getKorsinikById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Korisnik)session.createCriteria(Korisnik.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public Korisnik getKorsinikByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Korisnik)session.createCriteria(Korisnik.class).add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public List<Rezervacija> getListaRezervacijaPoKorisniku(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Rezervacija.class).add(Restrictions.eq("korisnik", korisnik)).list();
	}
	
	@Override
	public void deleteKorisnik(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(korisnik);
		session.getTransaction().commit();
		session.flush();
		
		
		UserRole role = (UserRole)session.createCriteria(UserRole.class).add(Restrictions.eq("username", korisnik.getUsername())).uniqueResult();
		System.err.println("User role je: " + role);
		session.delete(role);
		session.getTransaction().commit();
		session.flush();
		User user = (User)session.createCriteria(User.class).add(Restrictions.eq("username", korisnik.getUsername())).uniqueResult();
		System.err.println("User je: " + user);
		session.delete(user);
		session.flush();
	}
 
}
