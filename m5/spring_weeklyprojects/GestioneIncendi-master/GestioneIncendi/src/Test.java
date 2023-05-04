import static org.junit.jupiter.api.Assertions.*;

import GestioneIncendi.CentroControllo.CentroControllo;
import GestioneIncendi.Sonda.Sonda;

class Test {

	@org.junit.jupiter.api.Test
	void testUpdate() {
		CentroControllo c = new CentroControllo("localhost");
		Sonda s1 = new Sonda(1,233223,3223,2);
		s1.addObserver(c);
		s1.setLivelloFumo(9);
		assertTrue(c.getNumeroNotifiche()==1);
	}

}
