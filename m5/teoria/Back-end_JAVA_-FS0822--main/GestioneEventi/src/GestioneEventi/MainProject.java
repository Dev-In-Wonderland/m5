package GestioneEventi;

import java.time.LocalDate;

import Dao.EventoDAO;
import model.Evento;
import model.TipoEvento;

public class MainProject {

	public static void main(String[] args) {
		System.out.println("Run...");
		
		Evento e = new Evento();
		e.setTitolo("Evento Test");
		e.setDataEvento(LocalDate.of(2023, 03, 29));
		e.setDescrizione("Mio Evento bellissimo!!!");
		e.setNumeroMassimoPartecipanti(40);
		e.setTipoEvento(TipoEvento.PRIVATO);
		
		EventoDAO ed = new EventoDAO();
		ed.save(e);

	}

}
