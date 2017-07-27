package com.it355.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.it355.entities.data.Tehnologija;

@Entity
@Table(name = "sala")
public class Sala implements Serializable {

	private static final long serialVersionUID = -2351344813674921232L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "broj_sedista")
	private int brojSedista;
	@Column(name = "tehnologija")
	@Enumerated(EnumType.STRING)
	private Tehnologija tehnologija;

	public Sala() {
	}

	public Sala(Integer id, String naziv, int brojSedista, Tehnologija tehnologija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojSedista = brojSedista;
		this.tehnologija = tehnologija;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public Tehnologija getTehnologija() {
		return tehnologija;
	}

	public void setTehnologija(Tehnologija tehnologija) {
		this.tehnologija = tehnologija;
	}

	@Override
	public String toString() {
		return "Sala [naziv=" + naziv + ", brojSedista=" + brojSedista + ", tehnologija=" + tehnologija + "]";
	}

}
