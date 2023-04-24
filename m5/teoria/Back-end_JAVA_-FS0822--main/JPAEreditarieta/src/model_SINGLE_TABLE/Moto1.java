package model_SINGLE_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Moto")
public class Moto1 extends Veicolo1 {

	private Integer nposti;

	public Integer getNposti() {
		return nposti;
	}

	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}
	
	
	
}
