package dogs;

import abstracts.Controller.Verb;
import dogs.controllers.ApplicationController;
import dogs.models.Client;
import helpers.ApplicationRouting;

public class MainAppDogs {
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		ApplicationRouting.invoke(ApplicationController.class, Verb.Index);
		
		Client goerge = new Client("George", "Hub", "3");
		goerge.persist();
	}
}
