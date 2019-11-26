package dogs;

import abstracts.Controller.Verb;
import dogs.controllers.ApplicationController;
import helpers.ApplicationRouting;

public class MainAppDogs {
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		ApplicationRouting.invoke(ApplicationController.class, Verb.Index);
	}
}
