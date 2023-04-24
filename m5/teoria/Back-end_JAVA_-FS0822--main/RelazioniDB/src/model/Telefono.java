package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefoni")
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String gestore;
	private String numero;
	
	@ManyToOne
	private Utente utente;

	public Telefono() {
		super();
	}

	public Telefono(String gestore, String numero, Utente utente) {
		super();
		this.gestore = gestore;
		this.numero = numero;
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGestore() {
		return gestore;
	}

	public void setGestore(String gestore) {
		this.gestore = gestore;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", gestore=" + gestore + ", numero=" + numero + ", utente=" + utente + "]";
	}
	
	

}
