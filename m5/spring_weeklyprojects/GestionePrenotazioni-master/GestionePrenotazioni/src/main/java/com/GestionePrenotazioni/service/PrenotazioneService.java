package com.GestionePrenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.repository.PostazioneDAORepository;
import com.GestionePrenotazioni.repository.PrenotazioneDAORepository;

@Service
public class PrenotazioneService {
	@Autowired
	private PrenotazioneDAORepository repo;

	@Autowired
	@Qualifier("ParamsPrenotazione")
	private ObjectProvider<Prenotazione> paramsPrenotazioneProvider;

	@Autowired
	PrenotazioneDAORepository prenotazioneDAORepository;

	public void insertPrenotazione(Prenotazione u) {
		repo.save(u);
	}

	public void createPrenotazione(Utente utente, Postazione p, LocalDate data) {
		Prenotazione u = paramsPrenotazioneProvider.getObject(utente, p, data);
		List<Prenotazione> dataList= prenotazioneDAORepository.findByDataBetween(data,data.plusDays(1),p);
		if (!dataList.isEmpty() ) {
	
			System.out.println("La postazione risulta occupata per questa data! selezione un altra data");
		} else {
			
			List<Prenotazione> uList= prenotazioneDAORepository.findByDataUtente(data,utente);
			if(uList.size()<1) {
					insertPrenotazione(u);
				
			}else {System.out.println("L'utente selezionato ha già prenotato una postazione per questa data!");}
		
		}
	}

	public Prenotazione findPrenotazioneById(Long id) {
		return repo.findById(id).get();
	}

	public List<Prenotazione> findAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}

	public void removePrenotazione(Long id) {
		repo.deleteById(id);
	}

	public void updatePrenotazione(Prenotazione u) {
		repo.save(u);
	}
}
