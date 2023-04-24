package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.repository.EdificioDAORepository;


@Service
public class EdificioService {
	@Autowired private EdificioDAORepository repo;
	@Autowired @Qualifier("FakeEdificio") private ObjectProvider<Edificio> fakeEdificioProvider;
	@Autowired @Qualifier("ParamsEdificio") private ObjectProvider<Edificio> paramsEdificioProvider;
	
	public void createFakeEdificio() {
		Edificio u= fakeEdificioProvider.getObject();
		insertEdificio(u);

	}
	
	

	
	public void insertEdificio(Edificio u) {
		repo.save(u);
	}
	public void createEdificio(String nome, String indirizzo, String città, Postazione postazione
		) {
		Edificio u= paramsEdificioProvider.getObject( nome,  indirizzo,  città,  postazione); 
		insertEdificio(u);
	}

	public Edificio findEdificioById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Edificio> findAllEdificio() {
		return (List<Edificio>) repo.findAll();
	}
	
	public void removeUtente(Long id) {
		repo.deleteById(id);
	}
	public void updateUtente(Edificio u) {
		repo.save(u);
	}
}
