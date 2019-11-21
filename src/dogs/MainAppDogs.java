package dogs;

import dogs.controllers.ApplicationController;
import helpers.ApplicationRouting;
import interfaces.IController.Verb;

public class MainAppDogs {
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		ApplicationRouting.invoke(ApplicationController.class, Verb.Index);
	}
}
