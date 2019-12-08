package dogs.models;

import interfaces.IModel;

public interface IClient extends IModel {
	public String getFirstName();
	
	public String getLastName();
	
	public String getPhoneNumber();
	
	public void setFirstName(final String firstName);
	
	public void setName(final String lastName);
		
	public void setPhoneNumber(final String phoneNumber);
	
	public String toString();
}
