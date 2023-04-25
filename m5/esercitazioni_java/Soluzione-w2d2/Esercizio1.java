package it.epicode.exercises.week3.giorno2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio1 {
	private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);

	public static void main(String[] args) {
		Set<String> setParole = new HashSet<String>();

		boolean continua = true;

		do {
			try {
				System.out.println("Inserisci il numero di elementi seguito dal tasto Invio. Inserisci 0 per uscire");

				Scanner scanner = new Scanner(System.in);

				// E' necessario perchè usando nextInt, poi lo scanner ha un comportamento
				// inatteso con il successivo comando nextLine
				int numElementi = Integer.valueOf(scanner.nextLine());				

				if (numElementi == 0) {
					continua = false;
				} else {
					for (int i = 0; i < numElementi; i++) {
						System.out.println("Inserisci una parola seguita dal tasto Invio");
						String parola = scanner.nextLine();

						// Aggiunge la parola al set. Se il set contiene già la parola, essa
						// non viene aggiunta e ritorna false, altrimenti ritorna true
						boolean parolaAggiunta = setParole.add(parola);

						if (!parolaAggiunta) {
							// Se la parola non è stata aggiunta è un duplicato
							System.out.println("Parola duplicata: " + parola);
						}
					}

					System.out.println("Numero parole distinte: " + setParole.size());

					System.out.println("Parole distinte: ");
					// Itera su tutti gli elementi del set
					for (String parolaCorrente : setParole) {
						System.out.println("- " + parolaCorrente);
					}
					// Svuota il set
					setParole.clear();
				}

			} catch (Exception e) {
				logger.error("Errore. La procedura riprenderà dall'inizio");
				// Svuota il set
				setParole.clear();
			}

		} while (continua == true);
		System.out.println("Programma terminato");

	}

}
