package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.MainAppDogs;
import dogs.controllers.ClientController;
import dogs.models.IClient;
import exceptions.ModelNotPersistedException;

class ClientControllerTest {

	@Test
	void update_change_infos_of_model_with_given_id() throws ModelNotPersistedException {
		// Arrange
		final String ANY_OTHER_NAME = "Alex";
		IClient client = ClientTest.createAnyClient();
		MainAppDogs.clientRepository.insert(client);
		
		// Act
		ClientController.update(client.getId(), ANY_OTHER_NAME, client.getLastName(), client.getPhoneNumber());
		
		// Assert
		IClient storedClient = MainAppDogs.clientRepository.select(client.getId());
		assertEquals(ANY_OTHER_NAME, storedClient.getFirstName());
	}

	@Test
	void store_create_new_instance_with_given_attibutes() {
		// Act
		ClientController.store(ClientTest.ANY_FIRSTNAME, ClientTest.ANY_LASTNAME, ClientTest.ANY_PHONENUMBER);
	}

}
