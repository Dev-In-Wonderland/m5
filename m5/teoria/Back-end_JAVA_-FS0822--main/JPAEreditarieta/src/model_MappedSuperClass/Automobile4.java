package model_MappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "automobili_4")
public class Automobile4 extends Veicolo4 {
	
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
