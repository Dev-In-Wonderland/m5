package com.GestionePrenotazioni.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edifici")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Edificio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	private String città;
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.MERGE)
	private List<Postazione> postazione;

	
	public Edificio(String nome, String indirizzo, String città, List<Postazione> postazione,
			List<Prenotazione> prenotazione) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.città = città;
		this.postazione = postazione;
		if(postazione != null ) {
		this.postazione.forEach(e->e.setEdificio(this));
		}
	} 
	
}
