package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import dogs.models.IClient;

class DogTest {

	public final static String ANY_FIRSTNAME = "Gob";
	public final static Breed ANY_BREED = Breed.AIDI;
	
	public static Dog createAnyDog() {
		return new Dog(ANY_FIRSTNAME, ANY_BREED, null);
	}

	@Test
	void GIVEN_DogWithAName_THEN_NameIsReturned() {
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
	void GIVEN_SetName_THEN_NameIsReturedWhenGetNameIsCalled() {
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
	void GIVEN_DogWithBreed_THEN_BreedIsReturned() {
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
	void GIVEN_SetBreed_THEN_BreedIsReturedWhenGetBreedIsCalled() {
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
	void GIVEN_DogWithOwner_THEN_OwnerIsReturned() {
		// Arrange
		Dog dog = new Dog(ANY_FIRSTNAME, ANY_BREED, null);
		// Act
		Client returnedOwner = dog.getOwner();
		
		// Assert
		Client ExpectedOwner = null;
		assertEquals(ExpectedOwner, returnedOwner);
	}

	@Test
	void GIVEN_OwnerName_RETURNS_OWNER_NAME() {
        // Arrange
        IClient client = ClientTest.createAnyClient();
        Dog dog = new Dog(ANY_FIRSTNAME, ANY_BREED, (Client) client);
        
        // Act
        String returnedName = dog.getOwnerName();
        
        // Assert
        String expectedString = client.toString();
        assertEquals(expectedString, returnedName);
	}

	@Test
    void GIVEN_GetOwnerName_WHEN_no_owner_RETURNS_NO_OWNER_NAME() {
        // Arrange
        Dog dog = new Dog(ANY_FIRSTNAME, ANY_BREED, null);
        
        // Act
        String returnedName = dog.getOwnerName();
        
        // Assert
        assertEquals(Dog.NO_OWNER_NAME, returnedName);
    }
}
