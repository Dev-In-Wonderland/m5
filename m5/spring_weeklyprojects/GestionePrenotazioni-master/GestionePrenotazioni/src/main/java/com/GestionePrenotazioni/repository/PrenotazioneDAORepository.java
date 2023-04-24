package com.GestionePrenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.Utente;
@Repository
public interface PrenotazioneDAORepository extends CrudRepository<Prenotazione, Long>{
	public Prenotazione findByData(LocalDate data);
	//public List<Prenotazione> findByUsernameAndLastname(String uername, String lastname);
	//public List<Utente> findByAgeBetween(Integer min, Integer max);
	
	@Query(value="SELECT u FROM Prenotazione u WHERE u.data BETWEEN :data1 and :data2 and u.postazione= :p")
	public List<Prenotazione> findByDataBetween(LocalDate data1,LocalDate data2,Postazione p );
	@Query(value="SELECT u FROM Prenotazione u WHERE u.data = :data1 and u.utente= :utente")
	public List<Prenotazione> findByDataUtente(LocalDate data1,Utente utente );
}
