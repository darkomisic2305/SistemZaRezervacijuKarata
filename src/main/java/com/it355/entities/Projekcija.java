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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projekcija")
public class Projekcija implements Serializable {

	private static final long serialVersionUID = 6399528858075202063L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "id")
	private Film film;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "sala_id", referencedColumnName = "id")
	private Sala sala;
	@NotEmpty
	@Column(name = "datum")
	private String datum;
	@Pattern(regexp="^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
	@Column(name = "vreme")
	private String vreme;
	@Column(name = "slobodno_sedista")
	private int slobodnoSedista;

	public Projekcija() {
	}

	public Projekcija(Integer id, Film film, Sala sala, String datum, String vreme) {
		super();
		this.id = id;
		this.film = film;
		this.sala = sala;
		this.datum = datum;
		this.vreme = vreme;
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

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public int getSlobodnoSedista() {
		return slobodnoSedista;
	}

	public void setSlobodnoSedista(int slobodnoSedista) {
		this.slobodnoSedista = slobodnoSedista;
	}

	@Override
	public String toString() {
		return "Projekcija [film=" + film + ", sala=" + sala + ", datum=" + datum + ", vreme=" + vreme
				+ ", slobodnoSedista=" + slobodnoSedista + "]";
	}

}
