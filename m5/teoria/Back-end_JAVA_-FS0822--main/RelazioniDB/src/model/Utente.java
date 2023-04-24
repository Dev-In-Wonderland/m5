package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	
	@OneToOne
	private Indirizzo indirizzo;
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	private Set<Telefono> listaTelefoni;
	
	@ManyToMany(mappedBy = "studenti")
	private Set<Corso> listaCorsi;

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, Indirizzo indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.indirizzo.setUtente(this);
	}

	public Set<Telefono> getListaTelefoni() {
		return listaTelefoni;
	}

	public void setListaTelefoni(Set<Telefono> listaTelefoni) {
		this.listaTelefoni = listaTelefoni;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + "]";
	}
	
	

}
