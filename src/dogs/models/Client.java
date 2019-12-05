package dogs.models;

import abstracts.AbstractModel;

public class Client extends AbstractModel {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Client(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	//Getter
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
	public void setName(String lastName) {
		this.lastName = lastName;
	}	
		
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
