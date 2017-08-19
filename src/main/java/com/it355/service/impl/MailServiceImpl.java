package com.it355.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.it355.entities.Korisnik;
import com.it355.entities.Rezervacija;
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

	@Override
	public void sendReservationEMail(Rezervacija rezervacija, Locale locale) {
SimpleMailMessage message = new SimpleMailMessage();
		
		if(locale.getLanguage().equals("sr")) {
			message.setTo(rezervacija.getKorisnik().getEmail());
			message.setSubject("Uspešna rezervacija!");
			String postovani = "";
			if(rezervacija.getKorisnik().getPol().equals("Muški")) {
				postovani = "Poštovani ";
			} else {
				postovani = "Poštovana ";
			}
			String ulaznice = "";
			if(rezervacija.getBrojKarata() == 1) {
				ulaznice = "ulaznicu";
			} else if(rezervacija.getBrojKarata() == 5) {
				ulaznice = "ulaznica";
			} else {
				ulaznice = "ulaznice";
			}
			message.setText(postovani + rezervacija.getKorisnik().getIme() + " ,\n\nUspešno ste rezervisali " + rezervacija.getBrojKarata() + " " + ulaznice + " za film " + rezervacija.getProjekcija().getFilm().getNaslov() + "!\n Projekcija filma je " + rezervacija.getProjekcija().getDatum() + " u " + rezervacija.getProjekcija().getVreme() + " sati. \n\nMolimo Vas da budete u bioskopu najkasnije pola sata pre projekcije, kako biste preuzeli svoje ulaznice." + "\n\nHvala što koristite naš sistem!");
		} else {
			String ulaznice = "";
			if(rezervacija.getBrojKarata() == 1) {
				ulaznice = "ticket";
			} else {
				ulaznice = "tickets";
			}
			
			message.setTo(rezervacija.getKorisnik().getEmail());
			message.setSubject("Reservation successful!");
			message.setText("Dear " + rezervacija.getKorisnik().getIme() + " ,\n\nYou have successfully reserved " + rezervacija.getBrojKarata() + " " + ulaznice + " for movie " + rezervacija.getProjekcija().getFilm().getNaslov() + "!\n Projection is on " + rezervacija.getProjekcija().getDatum() + " in " + rezervacija.getProjekcija().getVreme() + ". \n\nPlease be in cinema half hour before projection, to take your " + ulaznice + ".\n\nThank you for using our system!");
		}
		mailSender.send(message);
		System.out.println("Mail za rezevaciju je poslat na adresu " + rezervacija.getKorisnik().getEmail());
	}
}
