package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.ApplicationSeeder;
import dogs.models.Dog;
import dogs.models.IClient;
import interfaces.IRepository;
import utils.Repository;

class ApplicationSeederTest {
	
	@Test
	void run_add_stuff_to_database() {
		// Assert
		IRepository<Dog> dogRepository = new Repository<Dog>();
		IRepository<IClient> clientRepository = new Repository<IClient>();
		
		// Act
		ApplicationSeeder.run(dogRepository, clientRepository);
		
		// Assert
		assertDoesNotThrow(() -> {
			clientRepository.select(0);
			dogRepository.select(0);
		});
	}
}
