package com.it355.service;

import java.util.Locale;

import com.it355.entities.Korisnik;

public interface MailService {

	public void sendMail(String to, String subject, String text);
	
	public void sendRegisterEMail(Korisnik korisnik, Locale locale);
	
}
