package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.models.Client;

class ClientTest {

	public final static String ANY_FIRSTNAME = "Gob";
	public final static String ANY_LASTNAME = "Braton";
	public final static String ANY_PHONENUMBER = "420-911-1825";
	
	public static Client createAnyClient() {
		return new Client(ANY_FIRSTNAME, ANY_LASTNAME, ANY_PHONENUMBER);
	}

	@Test
	void GIVEN_ClientWithAFirstName_THEN_ClienIsReturned() {
		// Arrange
		final String FIRSTNAMETEST = "Joe";
		Client client = new Client(FIRSTNAMETEST, ANY_LASTNAME, ANY_PHONENUMBER);
		// Act
		String returnedFirstName = client.getFirstName();
		
		// Assert
		String ExpectedName = "Joe";
		assertEquals(ExpectedName, returnedFirstName);
	}

	@Test
	void GIVEN_ClientWithALastName_THEN_ClienIsReturned() {
		// Arrange
		final String LASTNAMETEST = "Marcus";
		Client client = new Client(ANY_FIRSTNAME, LASTNAMETEST, ANY_PHONENUMBER);
		// Act
		String returnedFirstName = client.getLastName();
		
		// Assert
		String ExpectedName = "Marcus";
		assertEquals(ExpectedName, returnedFirstName);
	}

	@Test
	void GIVEN_ClientWithAPhoneNumber_THEN_ClienIsReturned() {
		// Arrange
		final String PHONENUMBER = "418-831-3560";
		Client client = new Client(ANY_FIRSTNAME, ANY_LASTNAME, PHONENUMBER);
		// Act
		String returnedFirstName = client.getPhoneNumber();
		
		// Assert
		String ExpectedPhoneNumber = "418-831-3560";
		assertEquals(ExpectedPhoneNumber, returnedFirstName);
	}

	@Test
	void GIVEN_SetFirstName_THEN_ClienIsReturnedWithAGetFirstName() {
		// Arrange
		final String FIRSTNAMETEST = "Joe";
		Client client = new Client(FIRSTNAMETEST, ANY_LASTNAME, ANY_PHONENUMBER);
		// Act
		client.setFirstName(FIRSTNAMETEST);
		
		String returnedFirstName = client.getFirstName();
		// Assert
		assertEquals(FIRSTNAMETEST, returnedFirstName);
	}

	@Test
	void GIVEN_SetName_THEN_ClienIsReturnedWithAGetName() {
		// Arrange
		final String LASTNAMETEST = "Marcus";
		Client client = new Client(ANY_FIRSTNAME, LASTNAMETEST, ANY_PHONENUMBER);
		// Act
		client.setName(LASTNAMETEST);
		
		// Assert
		String returnedLastName = client.getLastName();
		assertEquals(LASTNAMETEST, returnedLastName);
	}

	@Test
	void GIVEN_SetPhoneNumber_THEN_ClienIsReturnedWithAGetPhoneNumber() {
		// Arrange
		final String PHONENUMBER = "418-831-3560";
		Client client = new Client(ANY_FIRSTNAME, ANY_LASTNAME, PHONENUMBER);
		// Act
		client.setPhoneNumber(PHONENUMBER);
		
		// Assert
		String returnedPhoneNumber = client.getPhoneNumber();
		assertEquals(PHONENUMBER, returnedPhoneNumber);
	}
}
