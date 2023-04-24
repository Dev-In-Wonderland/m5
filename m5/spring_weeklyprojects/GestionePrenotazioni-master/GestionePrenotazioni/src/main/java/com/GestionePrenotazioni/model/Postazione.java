package com.GestionePrenotazioni.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Postazione implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private Tipo_postazione tipologia;
	private Integer num_max;
	@ManyToOne( cascade = CascadeType.MERGE)
	private Edificio edificio;
	@OneToMany(mappedBy = "postazione")
	private List<Prenotazione> prenotazione;
	
	public Postazione(String descrizione, Tipo_postazione tipologia, Integer num_max, Edificio edificio, List<Prenotazione> prenotazione) {
		super();
		this.descrizione = descrizione;
		this.tipologia = tipologia;
		this.num_max = num_max;
		this.edificio = edificio;
		this.prenotazione =  prenotazione;
		if(prenotazione != null) {this.prenotazione.forEach(e->e.setPostazione(this));}
		
	}
	
}
