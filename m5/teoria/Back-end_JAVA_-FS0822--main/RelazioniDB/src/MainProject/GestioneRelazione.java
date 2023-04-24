package MainProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Indirizzo;
import model.Utente;

public class GestioneRelazione {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelazioniDB");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		Indirizzo i = new Indirizzo("Via abc", 25, "Roma", "Roma");
		Utente u = new Utente("Mario", "Rossi", i);
		//i.setUtente(u);
		
		//System.out.println(u.getIndirizzo().getVia());
		//System.out.println(i.getUtente().getCognome());
	}
	
	

}
