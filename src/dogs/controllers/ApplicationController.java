package dogs.controllers;

import dogs.models.Dog;
import dogs.views.WelcomeView;
import interfaces.IController;

@SuppressWarnings("rawtypes")
public class ApplicationController implements IController {

	/**
	 * @since Exercice 4, step 1
	 */
	@Override
	public void index() {
		new WelcomeView();
	}
}
