package dogs.views.Clients.components;

import javax.swing.BorderFactory;

import dogs.controllers.ClientController;

@SuppressWarnings("serial")
public class ClientCreateForm extends ClientForm {
	final static String TITLE = "Ajouter un client";
	
	public ClientCreateForm() {
		super();
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
	}

	@Override
	protected void onSubmit(final String firstName, final String lastName, final String phoneNumber) {
		ClientController.store(firstName, lastName, phoneNumber);
	}
}
