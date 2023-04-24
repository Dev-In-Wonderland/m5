package model_JOINED;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "automobili_2")
public class Automobile2 extends Veicolo2 {
	
	private Integer nporte;
	private String alimentazione;
	
	public Integer getNporte() {
		return nporte;
	}
	public void setNporte(Integer nporte) {
		this.nporte = nporte;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	
}
