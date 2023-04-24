package com.GestionePrenotazioni.service;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.repository.UtenteDAORepository;


	@Service
public class UtenteService {


		@Autowired private UtenteDAORepository repo;
		@Autowired @Qualifier("FakeUtente") private ObjectProvider<Utente> fakeUserProvider;
		@Autowired @Qualifier("AdminUtente") private ObjectProvider<Utente> adminUserProvider;
		@Autowired @Qualifier("ParamsUtente") private ObjectProvider<Utente> paramsUtenteProvider;
		
		public void createFakeUtente() {
			Utente u= fakeUserProvider.getObject();
			insertUtente(u);

		}
		
		
	
		
		public void insertUtente(Utente u) {
			repo.save(u);
		}
		public void createUtente(String name, String lastname, String username, String email, List<Prenotazione> prenotazioni) {
			Utente u= paramsUtenteProvider.getObject( name,  lastname,  username,  email, prenotazioni); 
			insertUtente(u);
		}

		public Utente findUtenteById(Long id) {
			return repo.findById(id).get();
		}
		
		public List<Utente> findAllUtente() {
			return (List<Utente>) repo.findAll();
		}
		
		public void removeUtente(Long id) {
			repo.deleteById(id);
		}
		public void updateUtente(Utente u) {
			repo.save(u);
		}
	}


