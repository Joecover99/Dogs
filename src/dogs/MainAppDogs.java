package dogs;

import dogs.controllers.ApplicationController;

public class MainAppDogs {
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		ApplicationSeeder.run();
		ApplicationController.index();
	}
}
