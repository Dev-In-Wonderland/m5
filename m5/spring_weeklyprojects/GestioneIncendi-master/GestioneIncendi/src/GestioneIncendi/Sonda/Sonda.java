package GestioneIncendi.Sonda;

public class Sonda extends Subject{
	public final int LIVELLO_MAX=5;
	private long id;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	public int getLivelloFumo() {
		return livelloFumo;
	}
	public void setLivelloFumo(int livelloFumo) {
		this.livelloFumo = livelloFumo;
		if(livelloFumo > LIVELLO_MAX) {
			super.notifyObservers();
		}
	}
	public int getLIVELLO_MAX() {
		return LIVELLO_MAX;
	}
	public Sonda(long id, double latitudine, double longitudine, int livelloFumo) {
		super();
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
	}


}
