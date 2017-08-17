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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.it355.entities.data.Zanr;

@Entity
@Table(name = "film")
public class Film implements Serializable {

	private static final long serialVersionUID = -2778636544416164667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@NotEmpty
	@Column(name = "naslov")
	private String naslov;
	@NotEmpty
	@Column(name = "originalni_naslov")
	private String originalniNaslov;
	@NotEmpty
	@Column(name = "pocetak_prikazivanja")
	private String pocetakPrikazivanja;
	@Column(name = "duzina_trajanja")
	private int duzinaTrajanja;
	@NotEmpty
	@Column(name = "drzava")
	private String drzava;
	@Column(name = "godina")
	private String godina;
	@Column(name = "zanr")
	@Enumerated(EnumType.STRING)
	private Zanr zanr;
	@NotEmpty
	@Column(name = "opis")
	private String opis;
	@NotEmpty
	@Column(name = "youtube_url")
	private String youtubeUrl;

	@Transient
	private MultipartFile slika;

	public Film() {
	}

	public Film(Integer id, String naslov, String originalniNaslov, String pocetakPrikazivanja, int duzinaTrajanja,
			String drzava, String godina, Zanr zanr, String opis, String youtubeUrl) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pocetakPrikazivanja = pocetakPrikazivanja;
		this.duzinaTrajanja = duzinaTrajanja;
		this.drzava = drzava;
		this.godina = godina;
		this.zanr = zanr;
		this.opis = opis;
		this.youtubeUrl = youtubeUrl;
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

	public String getPocetakPrikazivanja() {
		return pocetakPrikazivanja;
	}

	public void setPocetakPrikazivanja(String pocetakPrikazivanja) {
		this.pocetakPrikazivanja = pocetakPrikazivanja;
	}

	public int getDuzinaTrajanja() {
		return duzinaTrajanja;
	}

	public void setDuzinaTrajanja(int duzinaTrajanja) {
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public MultipartFile getSlika() {
		return slika;
	}

	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	@Override
	public String toString() {
		return "Film [naslov=" + naslov + ", originalniNaslov=" + originalniNaslov + ", pocetakPrikazivanja="
				+ pocetakPrikazivanja + ", duzinaTrajanja=" + duzinaTrajanja + ", drzava=" + drzava + ", godina="
				+ godina + ", zanr=" + zanr + ", opis=" + opis + ", youtubeUrl=" + youtubeUrl + "]";
	}

}
