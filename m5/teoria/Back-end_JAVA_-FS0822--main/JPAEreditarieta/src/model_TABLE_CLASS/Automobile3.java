package model_TABLE_CLASS;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "automobili_3")
public class Automobile3 extends Veicolo3 {
	
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
