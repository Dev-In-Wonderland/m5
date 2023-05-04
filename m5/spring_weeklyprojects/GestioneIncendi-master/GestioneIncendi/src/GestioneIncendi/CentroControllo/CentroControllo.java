package GestioneIncendi.CentroControllo;

import GestioneIncendi.Sonda.Observer;
import GestioneIncendi.Sonda.Sonda;
import GestioneIncendi.Sonda.Subject;

public class CentroControllo implements Observer {

    private String url="http://alarm?";
    private int numeroNotifiche = 0;
    public CentroControllo(String url) {
        this.url = url;
    }
	
	@Override
	public void update(Subject  s) {
		   if (s instanceof Sonda) {
			   Sonda s1 = (Sonda) s;
		if(s1.getLivelloFumo()>s1.getLIVELLO_MAX()) {
			  String path = url+"idsonda="+s1.getId()+"&lat=" + s1.getLatitudine()+ " &lon= " +s1.getLongitudine()+ "&smokelevel=" + s1.getLivelloFumo();
		            System.out.println("INCENDIO!!! Invio notifica: " + path);
		            numeroNotifiche = numeroNotifiche +1;
	}}

}

	public int getNumeroNotifiche() {
		return numeroNotifiche;
	}

	public void setNumeroNotifiche(int numeroNotifiche) {
		this.numeroNotifiche = numeroNotifiche;
	}




}