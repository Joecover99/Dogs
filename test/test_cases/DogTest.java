package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;

class DogTest {

	public final static String ANY_FIRSTNAME = "Gob";
	public final static Breed ANY_BREED = Breed.AIDI;
	
	public static Dog createAnyDog() {
		return new Dog(ANY_FIRSTNAME, ANY_BREED, null);
	}

	@Test
	void testGetName() {
		// Arrange
		final String FIRSTNAMETEST = "Joe";
		Dog dog = new Dog(FIRSTNAMETEST, ANY_BREED, null);
		// Act
		String returnedFirstName = dog.getName();
		
		// Assert
		String ExpectedName = "Joe";
		assertEquals(ExpectedName, returnedFirstName);
	}

	@Test
	void testSetName() {
		// Arrange
		final String FIRSTNAMETEST = "Joe";
		Dog dog = new Dog(FIRSTNAMETEST, ANY_BREED, null);
		// Act
		dog.setName(FIRSTNAMETEST);
		
		String returnedFirstName = dog.getName();
		// Assert
		assertEquals(FIRSTNAMETEST, returnedFirstName);
	}

	@Test
	void testGetBreed() {
		// Arrange
		final Breed BREED = Breed.BOXER;
		Dog dog = new Dog(ANY_FIRSTNAME, BREED, null);
		// Act
		Breed returnedBreed = dog.getBreed();
		
		// Assert
		Breed ExpectedBreed = Breed.BOXER;
		assertEquals(ExpectedBreed, returnedBreed);
	}


	@Test
	void testSetBreed() {
		// Arrange
		final Breed BREED = Breed.BOXER;
		Dog dog = new Dog(ANY_FIRSTNAME, BREED, null);
		// Act
		dog.setBreed(BREED);
		
		Breed returnedFirstName = dog.getBreed();
		// Assert
		assertEquals(BREED, returnedFirstName);
	}

	@Test
	void testGetOwner() {
		// Arrange
		Dog dog = new Dog(ANY_FIRSTNAME, ANY_BREED, null);
		// Act
		Client returnedOwner = dog.getOwner();
		
		// Assert
		Client ExpectedOwner = null;
		assertEquals(ExpectedOwner, returnedOwner);
	}

	@Test
	void testGetOwnerName() {
		// Arrange
		final String CLIENT_NAME = "Star";
		final String LASTNAME = "bb";
		final String PHONENUMBER = "418-831-3560";
		Client client = new Client(CLIENT_NAME, LASTNAME, PHONENUMBER);
		Dog dog = new Dog(ANY_FIRSTNAME, ANY_BREED, client);
		// Act
		String returnedOwner = dog.getOwnerName();
		
		// Assert
		Client ExpectedOwner = client;
		assertEquals(ExpectedOwner, returnedOwner);
	}

}
