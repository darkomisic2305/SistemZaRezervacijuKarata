package com.it355.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.it355.entities.Korisnik;
import com.it355.entities.data.Pol;
import com.it355.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
		System.out.println("Mail je poslat na adresu " + to);
	}
	
	@Override
	public void sendRegisterEMail(Korisnik korisnik, Locale locale) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		if(locale.getLanguage().equals("sr")) {
			message.setTo(korisnik.getEmail());
			message.setSubject("Uspešna registracija!");
			String postovani = "";
			if(korisnik.getPol().equals("Muški")) {
				postovani = "Poštovani ";
			} else {
				postovani = "Poštovana ";
			}
			message.setText(postovani + korisnik.getIme() + " ,\n\nUspešno ste izvršili registraciju! Vaše korisničko ime je: " + korisnik.getUsername() + ".\n\nHvala što koristite naš sistem!");
		} else {
			message.setTo(korisnik.getEmail());
			message.setSubject("Registration successful!");
			message.setText("Dear " + korisnik.getIme() + " ,\n\nYou have successfully registered! Your username is: " + korisnik.getUsername() + ".\n\nThank you for using our system!");
		}
		mailSender.send(message);
		System.out.println("Mail za registraciju je poslat na adresu " + korisnik.getEmail());
	}
}
