package model_JOINED;

import javax.persistence.Entity;

@Entity
public class Moto2 extends Veicolo2 {

	private Integer nposti;

	public Integer getNposti() {
		return nposti;
	}

	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}
	
	
	
}
