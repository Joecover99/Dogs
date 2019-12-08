package dogs;

import dogs.controllers.ApplicationController;
import dogs.models.Dog;
import dogs.models.IClient;
import interfaces.IRepository;
import utils.Repository;

public class MainAppDogs {
	
	public final static IRepository<Dog> dogRepository = new Repository<Dog>();
	public final static IRepository<IClient> clientRepository = new Repository<IClient>();
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		ApplicationSeeder.run(dogRepository, clientRepository);
		ApplicationController.index();
	}
}
