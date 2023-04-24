package model_MappedSuperClass;

import javax.persistence.Entity;

@Entity
public class Moto4 extends Veicolo4 {

	private Integer nposti;

	public Integer getNposti() {
		return nposti;
	}

	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}
	
	
	
}
