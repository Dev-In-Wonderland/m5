package it.epicode.exercises.week1.giorno3;

import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		// Inizializza lo scanner per l'acquisizione dell'input utente
		Scanner scanner = new Scanner(System.in);
		String[] stringhe = new String[3];
		
		System.out.println("Inserire ogni stringa seguita dal tasto Invio");
		System.out.println("Prima Stringa: ");
		stringhe[0] = scanner.nextLine();
		System.out.println("Seconda Stringa: ");
		stringhe[1] = scanner.nextLine();
		System.out.println("Terza Stringa: ");
		stringhe[2] = scanner.nextLine();
		
		System.out.println("Stringhe in ordine: ");
		System.out.println(stringhe[0] + " - " + stringhe[1] + " - " + stringhe[2]);
		
		System.out.println("Stringhe in ordine inverso: ");
		System.out.println(stringhe[2] + " - " + stringhe[1] + " - " + stringhe[0]);
		

	}

}
