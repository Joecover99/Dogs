package test_cases;

import org.junit.jupiter.api.Test;

import dogs.controllers.DogController;

class DogControllerTest {
	
	@Test
	void store() {
		DogController.store(DogTest.ANY_FIRSTNAME, DogTest.ANY_BREED, null);
	}

}
