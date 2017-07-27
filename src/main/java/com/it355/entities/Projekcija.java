package com.it355.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projekcija")
public class Projekcija implements Serializable {

	private static final long serialVersionUID = 6399528858075202063L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "id")
	private Film film;
	@ManyToOne
	@JoinColumn(name = "sala_id", referencedColumnName = "id")
	private Sala sala;
	@Column(name = "datum_vreme")
	private Date datumVreme;
	@Column(name = "slobodno_sedista")
	private int slobodnoSedista;

	public Projekcija() {
	}

	public Projekcija(Integer id, Film film, Sala sala, Date datumVreme) {
		super();
		this.id = id;
		this.film = film;
		this.sala = sala;
		this.datumVreme = datumVreme;
		this.slobodnoSedista = sala.getBrojSedista();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Date getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}

	public int getSlobodnoSedista() {
		return slobodnoSedista;
	}

	public void setSlobodnoSedista(int slobodnoSedista) {
		this.slobodnoSedista = slobodnoSedista;
	}

	@Override
	public String toString() {
		return "Projekcija [film=" + film + ", sala=" + sala + ", datumVreme=" + datumVreme + ", slobodnoSedista="
				+ slobodnoSedista + "]";
	}

}
