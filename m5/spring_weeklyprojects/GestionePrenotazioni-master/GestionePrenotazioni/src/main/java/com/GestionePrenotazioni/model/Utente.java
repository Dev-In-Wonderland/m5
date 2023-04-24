package com.GestionePrenotazioni.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Utente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private String username;
	private String email;
	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;
	public Utente(String name, String lastname, String username, String email, List<Prenotazione> prenotazioni) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.prenotazioni = prenotazioni;
		if(prenotazioni != null) {
		this.prenotazioni.forEach(e->e.setUtente(this));}
	}

}
