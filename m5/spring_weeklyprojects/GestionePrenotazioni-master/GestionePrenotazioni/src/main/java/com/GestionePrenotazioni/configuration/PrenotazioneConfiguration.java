package com.GestionePrenotazioni.configuration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Utente;

@Configuration
@PropertySource("classpath:application.properties")
public class PrenotazioneConfiguration {
	@Bean("CustomPrenotazione")
	@Scope("prototype")
	public Prenotazione customPrenotazione() {
		return new Prenotazione();
	}

	@Bean("ParamsPrenotazione")
	@Scope("prototype")
	public Prenotazione paramsPrenotazione(Utente utente, Postazione p, LocalDate data) {
		return new Prenotazione( utente,  p,  data);
	}


}
