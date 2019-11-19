package dogs;

import dogs.controller.DogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.model.DogMemoryRepository;
import dogs.model.IDogRepository;
import dogs.view.IDogController;
import dogs.view.WelcomeView;

public class MainAppDogs {

	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.createControllers();
	}
	
	private void createControllers() {
		IDogController dogController = new DogController(dogRepository);
		
		IWelcomeController appController = new WelcomeController(dogController);
		appController.startApplication();
	}
	
	private IDogRepository dogRepository = new DogMemoryRepository();
	
	private void seedData() {
		new DogDataSeeder(this.dogRepository);
	}
}
