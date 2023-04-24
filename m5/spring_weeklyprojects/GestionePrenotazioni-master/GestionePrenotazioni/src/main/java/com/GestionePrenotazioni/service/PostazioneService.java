package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Tipo_postazione;
import com.GestionePrenotazioni.repository.PostazioneDAORepository;

@Service
public class PostazioneService {
	@Autowired private PostazioneDAORepository repo;

	@Autowired @Qualifier("ParamsPostazione") private ObjectProvider<Postazione> paramsPostazioneProvider;
	

	

	
	public void insertPostazione(Postazione u) {
		repo.save(u);
	}
	public void createPostazione(String descrizione, Tipo_postazione tipologia, Integer num_max, Edificio edificio, List<Prenotazione> p) {
		Postazione u= paramsPostazioneProvider.getObject(descrizione,tipologia,num_max,edificio,p);
		insertPostazione(u);
	}

	public Postazione findPostazioneById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Postazione> findAllPostazione() {
		return (List<Postazione>) repo.findAll();
	}
	
	public void removePostazione(Long id) {
		repo.deleteById(id);
	}
	public void updatePostazione(Postazione u) {
		repo.save(u);
	}
}
