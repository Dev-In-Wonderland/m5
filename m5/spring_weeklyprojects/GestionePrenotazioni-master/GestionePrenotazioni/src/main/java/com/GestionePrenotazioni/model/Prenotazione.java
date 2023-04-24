package com.GestionePrenotazioni.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prenotazione implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Utente utente;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Postazione postazione;
	private LocalDate data;
	public Prenotazione(Utente utente, Postazione p, LocalDate data) {
		super();
		this.utente = utente;
		this.postazione = p;
		this.data = data;
	}

	
}
