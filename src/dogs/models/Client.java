package dogs.models;

import abstracts.AbstractModel;

public class Client extends AbstractModel {
	
//	public final static Class correspondingRepository = ClientRepository
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Client(final String firstName, final String lastName, final String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	//Getter
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	//Setter
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}	
	
	public void setName(final String lastName) {
		this.lastName = lastName;
	}	
		
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
