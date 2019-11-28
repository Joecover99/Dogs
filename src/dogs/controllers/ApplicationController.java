package dogs.controllers;

import abstracts.Controller;
import dogs.views.WelcomeView;

@SuppressWarnings("rawtypes")
public class ApplicationController extends Controller {

	/**
	 * @since Exercice 4, step 1
	 */
	@Override
	protected void index(Object arguments) {
		new WelcomeView();
	}
}
