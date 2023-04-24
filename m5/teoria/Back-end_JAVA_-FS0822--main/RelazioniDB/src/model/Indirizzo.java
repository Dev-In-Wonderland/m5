package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzi")
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private Integer civico;
	private String citta;
	private String provincia;
	
	@OneToOne(mappedBy = "indirizzo")
	private Utente utente;

	public Indirizzo() {
		super();
	}

	public Indirizzo(String via, Integer civico, String citta, String provincia) {
		super();
		this.via = via;
		this.civico = civico;
		this.citta = citta;
		this.provincia = provincia;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Integer getCivico() {
		return civico;
	}

	public void setCivico(Integer civico) {
		this.civico = civico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		provincia = provincia;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", via=" + via + ", civico=" + civico + ", citta=" + citta + ", Provincia="
				+ provincia + "]";
	}
	
	
	
}
