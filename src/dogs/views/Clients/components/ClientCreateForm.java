package dogs.views.Clients.components;

import javax.swing.BorderFactory;

import dogs.controllers.ClientController;
import dogs.models.Client;

@SuppressWarnings("serial")
public class ClientCreateForm extends ClientForm {
	final static String TITLE = "Ajouter un client";
	
	public ClientCreateForm() {
		super();
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
	}

	@Override
	protected void submit(Client newClient) {
		ClientController.store(newClient);
	}
}
