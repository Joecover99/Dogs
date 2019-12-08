package dogs.views.Clients.components;

import javax.swing.BorderFactory;

import abstracts.Controller.Verb;
import dogs.controllers.ClientController;
import dogs.models.Client;
import helpers.ApplicationRouting;

public class ClientCreateForm extends ClientForm {
	final static String TITLE = "Ajouter un client";
	public final static String FIRSTNAME_LABEL = "Prénom";
	public final static String LASTNAME_LABEL = "Nom";
	public final static String PHONE_NUMBER_LABEL = "Numéro de télephone";
	public final static String SUBMIT_LABEL = "Enregistrer";
	public final static String INVALID_INPUT_LABEL = "Veuillez remplire tous les champs.";
	
	final static String SUCCESS_LABEL = "Client enregistré.";
	
	public ClientCreateForm() {
		super();
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
	}

	@Override
	protected void submit(Client newClient) {
		ApplicationRouting.invoke(ClientController.class, Verb.Store, newClient);
	}
}
