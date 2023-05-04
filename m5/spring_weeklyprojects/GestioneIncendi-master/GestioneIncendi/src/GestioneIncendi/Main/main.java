package GestioneIncendi.Main;

import GestioneIncendi.CentroControllo.CentroControllo;
import GestioneIncendi.Sonda.Sonda;

public class main {

	public static void main(String[] args) {

	Sonda s= new Sonda(1, 1213424, 23432, 3);
	CentroControllo c= new CentroControllo("localhost");
	s.addObserver(c);
	s.setLivelloFumo(8);

	}

}
