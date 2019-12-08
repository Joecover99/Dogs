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
	void testClient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
