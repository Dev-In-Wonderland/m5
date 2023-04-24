package Ereditarieta;

import java.util.ArrayList;
import java.util.List;

public class GestioneEreditarieta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Veicolo v = new Automobile();
		
		List<Veicolo> listaVeicolo = new ArrayList<Veicolo>();
		
		listaVeicolo.add(new Automobile());
		listaVeicolo.add(new Moto());
		listaVeicolo.add(new Camper());
		// listaVeicolo.add(new Smartphone()); 
		
		listaVeicolo.forEach(ve -> {
			if(ve instanceof Camper) {
				
			}
			
			ve.acc();
		});
		
		
		List<Navigatore> oggConNavigatore = new ArrayList<>();
		
		oggConNavigatore.add(new Automobile());
		oggConNavigatore.add(new Smartphone());
		
		oggConNavigatore.forEach(n -> n.aggiornaFirmaware());

	}

}
