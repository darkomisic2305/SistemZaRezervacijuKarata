package com.it355.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;

import com.it355.entities.data.Pol;

@Entity
@Table(name = "korisnik")
public class Korisnik implements Serializable {

	private static final long serialVersionUID = 871265547314931005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@NotEmpty
	@Column(name = "ime")
	private String ime;
	@NotEmpty
	@Column(name = "prezime")
	private String prezime;
	@NotEmpty
	@Column(name = "email")
	private String email;
	@NotEmpty
	@Column(name = "username")
	private String username;
	@NotEmpty
	@Column(name = "password")
	private String password;
	@NotEmpty
	@Column(name = "pol")
	private String pol;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datum_rodjenja")
	private Date datumRodjenja;

	public Korisnik() {
	}

	public Korisnik(Integer id, String ime, String prezime, String email, String username, String password, String pol,
			Date datumRodjenja) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.username = username;
		this.password = password;
		this.pol = pol;
		this.datumRodjenja = datumRodjenja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", pol=" + pol + ", datumRodjenja=" + datumRodjenja + "]";
	}

}
