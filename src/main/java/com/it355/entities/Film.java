package com.it355.entities;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.it355.entities.data.Zanr;

@Entity
@Table(name = "film")
public class Film implements Serializable {

	private static final long serialVersionUID = -2778636544416164667L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "naslov")
	private String naslov;
	@Column(name = "originalni_naslov")
	private String originalniNaslov;
	@Column(name = "pocetak_prikazivanja")
	private Date pocetakPrikazivanja;
	@Column(name = "duzina_trajanja")
	private Duration duzinaTrajanja;
	@Column(name = "drzava")
	private String drzava;
	@Column(name = "godina")
	private String godina;
	@Column(name = "zanr")
	@Enumerated(EnumType.STRING)
	private Zanr zanr;

	public Film() {
	}

	public Film(Integer id, String naslov, String originalniNaslov, Date pocetakPrikazivanja, Duration duzinaTrajanja,
			String drzava, String godina, Zanr zanr) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pocetakPrikazivanja = pocetakPrikazivanja;
		this.duzinaTrajanja = duzinaTrajanja;
		this.drzava = drzava;
		this.godina = godina;
		this.zanr = zanr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public Date getPocetakPrikazivanja() {
		return pocetakPrikazivanja;
	}

	public void setPocetakPrikazivanja(Date pocetakPrikazivanja) {
		this.pocetakPrikazivanja = pocetakPrikazivanja;
	}

	public Duration getDuzinaTrajanja() {
		return duzinaTrajanja;
	}

	public void setDuzinaTrajanja(Duration duzinaTrajanja) {
		this.duzinaTrajanja = duzinaTrajanja;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	@Override
	public String toString() {
		return "Film [naslov=" + naslov + ", originalniNaslov=" + originalniNaslov + ", pocetakPrikazivanja="
				+ pocetakPrikazivanja + ", duzinaTrajanja=" + duzinaTrajanja + ", drzava=" + drzava + ", godina="
				+ godina + ", zanr=" + zanr + "]";
	}

}
