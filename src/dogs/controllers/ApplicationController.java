package dogs.controllers;

import dogs.views.WelcomeView;

/**
 * The main controller
 */
public class ApplicationController {
	public static void index() {
		new WelcomeView();
	}
}
