package dogs.controller;

import dogs.view.IDogController;
import dogs.view.IView;
import dogs.view.WelcomeView;

public class WelcomeController implements IWelcomeController {

	private IDogController dogController;
	
	public WelcomeController(IDogController dogController) {
		this.dogController = dogController;
	}

	public void startApplication() {;
		IView welcomeView = new WelcomeView(this);
		welcomeView.display();
	}

	@Override
	public void wantToCreateDog() {
		// TODO Auto-generated method stub
		this.dogController.goToCreate();
	}
}
