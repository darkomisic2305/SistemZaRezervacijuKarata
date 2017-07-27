package com.it355.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rezervacija")
public class Rezervacija implements Serializable {

	private static final long serialVersionUID = 4867570312279762783L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "korisnik_id", referencedColumnName = "id")
	private Korisnik korisnik;
	@ManyToOne
	@JoinColumn(name = "projekcija_id", referencedColumnName = "id")
	private Projekcija projekcija;
	@Column(name = "broj_karata")
	private int brojKarata;

	public Rezervacija() {
	}

	public Rezervacija(Integer id, Korisnik korisnik, Projekcija projekcija, int brojKarata) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.projekcija = projekcija;
		this.brojKarata = brojKarata;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public int getBrojKarata() {
		return brojKarata;
	}

	public void setBrojKarata(int brojKarata) {
		this.brojKarata = brojKarata;
	}

	@Override
	public String toString() {
		return "Rezervacija [korisnik=" + korisnik + ", projekcija=" + projekcija + ", brojKarata=" + brojKarata + "]";
	}

}
