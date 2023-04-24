package MainProject;

import DependencyInjection.Address;
import DependencyInjection.Person;

public class TestMain {

	public static void main(String[] args) {
		Address add = new Address("Via abc", 25, "Roma", "Roma");
		
		Person p1 = new Person("Mario Rossi", add, "12345");
		Person p2 = new Person();
		Person p3 = new Person();
		
		p2.setFullname("Giuseppe Verdi");
		p2.setPhone("084684");
		p2.setAddress(add);
		
		p3.fullname = "Francesca Neri";
		p3.phone = "7637592";
		p3.address = add;
	}

}
