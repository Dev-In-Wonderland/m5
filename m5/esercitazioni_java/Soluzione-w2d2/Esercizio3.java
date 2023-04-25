package it.epicode.exercises.week3.giorno2;

import java.util.HashMap;
import java.util.Map;

public class Esercizio3 {
	private static Map<String, String> rubrica = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		
	}
	
	public void aggiungiContatto(String numero, String nome) throws Exception {
		if (rubrica.containsKey(nome)) {
			throw new Exception("Contatto già presente in rubrica");
		} else {
			rubrica.put(nome, numero);
		}
	}
	
	public void rimuoviContatto(String nome) {
		rubrica.remove(nome);
	}
	
	public String ricercaNumero(String nome) {
		return rubrica.get(nome);
	}
	
	public String ricercaPersona(String numero) {
		String trovato = null;
		for (String curPersona : rubrica.keySet()) {
			if (numero.equals(rubrica.get(curPersona)))
				trovato = curPersona;
		}
		return trovato;
	}
	
	public void stampaRubrica() {
		System.out.println("*******     Rubrica     *******");
		for (String curPersona : rubrica.keySet()) {
			System.out.println("Nome: " + curPersona + " - Numero: " + rubrica.get(curPersona));
		}

		
	}
	

}
