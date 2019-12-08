package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.ApplicationSeeder;
import dogs.models.Client;
import dogs.models.Dog;
import interfaces.IRepository;
import utils.Repository;

class ApplicationSeederTest {
	
	@Test
	void testRun() {
		// Assert
		IRepository<Dog> dogRepository = new Repository<Dog>();
		IRepository<Client> clientRepository = new Repository<Client>();
		
		// Act
		ApplicationSeeder.run(dogRepository, clientRepository);
		
		// Assert
		fail("Not yet implemented"); // TODO test that data are added to repository
	}

}
