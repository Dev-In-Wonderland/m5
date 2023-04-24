package model_TABLE_CLASS;

import javax.persistence.Entity;

@Entity
public class Moto3 extends Veicolo3 {

	private Integer nposti;

	public Integer getNposti() {
		return nposti;
	}

	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}
	
	
	
}
