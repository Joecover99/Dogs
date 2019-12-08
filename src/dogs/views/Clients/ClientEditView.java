package dogs.views.Clients;

import components.View;
import dogs.controllers.ClientController;
import dogs.models.Client;
import dogs.views.Clients.components.ClientForm;
import exceptions.ModelNotPersistedException;

@SuppressWarnings("serial")
public class ClientEditView extends View {
	public final static String TITLE = "Modifier un client";
	
	public ClientEditView(Client client) {
		super(TITLE);
		
		View hostView = this;
		this.add(new ClientForm(client) {
			@Override
			protected void onSubmit(final String firstName, final String lastName, final String phoneNumber) {
				try {
					ClientController.update(client.getId(), firstName, lastName, phoneNumber);
				} catch (ModelNotPersistedException e) {
					// TODO
				}
				hostView.dispose();
			}
		});
		
		this.display();
	}
}
