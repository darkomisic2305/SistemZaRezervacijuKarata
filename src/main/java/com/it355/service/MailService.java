package com.it355.service;

import java.util.Locale;

import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;

public interface MailService {

	public void sendMail(String to, String subject, String text);
	
	public void sendRegisterEMail(Korisnik korisnik, Locale locale);
	
	public void sendReservationEMail(Rezervacija rezervacija, Locale locale);
}
