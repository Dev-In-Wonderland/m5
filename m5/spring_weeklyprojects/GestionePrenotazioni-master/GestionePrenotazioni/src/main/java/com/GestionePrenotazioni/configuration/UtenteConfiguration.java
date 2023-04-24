package com.GestionePrenotazioni.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Utente;


@Configuration
@PropertySource("classpath:application.properties")
public class UtenteConfiguration {
	@Bean("CustomUtente")
	@Scope("prototype")
	public Utente customUtente() {
		return new Utente();
	}

	@Bean("ParamsUtente")
	@Scope("prototype")
	public Utente paramsUtente(String name, String lastname,  String username,String email, List<Prenotazione> p) {
		return new Utente(name,lastname,username,email,p);
	}

	@Bean("FakeUtente")
	@Scope("prototype")
	public Utente fakeUtente() {
		Utente u = new Utente();
		Faker fake = new Faker(new Locale("it-IT"));
		u.setName(fake.name().firstName());
		u.setLastname(fake.name().lastName());
		u.setEmail(u.getName() + "." + u.getLastname() + "@example.com");
		u.setUsername(u.getName()+"-"+ u.getLastname() + fake.number().numberBetween(1, 160));
		return u;
	}
}
