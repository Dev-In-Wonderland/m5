package DependencyInjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Person {
	
	public String fullname;
	public Address address;
	public String phone;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String fullname, Address address, String phone) {
		super();
		this.fullname = fullname;
		//this.address = new Address("Via abc", 25, "Roma", "Roma");
		this.address = address;
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
