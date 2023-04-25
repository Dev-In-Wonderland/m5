package it.epicode.exercises.week1.giorno3;

public class Esercizio1 {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 23;
		int moltiplica = moltiplica(a, b);
		System.out.println("Risultato moltiplicazione: " + moltiplica);
		
		String stringa = "Formula";
		int numero = 1;
		String concatena = concatena(stringa, numero);
		System.out.println("Risultato concatenazione: " + concatena);
		
		String[] nuovoArray = inserisciInArray(new String[]{"A", "B","C", "D", "E"},"X");
		System.out.println("Terzo elemento array di arrivo: " + nuovoArray[2]);
		System.out.println("Sesto elemento array di arrivo: " + nuovoArray[5]);


	
	}
	
	public static int moltiplica(int a,int b) {
		return a*b;
	}
	
	
	public static String concatena( String stringa, int i) {
		String concatenata = stringa + i;
		
		return concatenata;
		
		
	}
	
	public static String[] inserisciInArray(String[] inputArray, String stringa) {
		System.out.println("Lunghezza array: " + inputArray.length);
		// Crea un nuovo array di dimensione 6
		String[] risultato = new String[6];
		
		System.out.println("Terzo elemento array di partenza: " + inputArray[2]);

		
		risultato[0] = inputArray[0];
		risultato[1] = inputArray[1];
		risultato[2] = stringa;
		risultato[3] = inputArray[2];
		risultato[4] = inputArray[3];
		risultato[5] = inputArray[4];
		
		System.out.println("Terzo elemento array di arrivo: " + risultato[2]);


		return risultato;
		
	}

}
