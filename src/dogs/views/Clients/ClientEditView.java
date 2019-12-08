package dogs.views.Clients;

import abstracts.AbstractView;
import dogs.controllers.ClientController;
import dogs.models.Client;
import dogs.views.Clients.components.ClientForm;

@SuppressWarnings("serial")
public class ClientEditView extends AbstractView {
	public final static String TITLE = "Modifier un client";
	
	public ClientEditView(Client client) {
		super(TITLE);
		
		AbstractView hostView = this;
		this.add(new ClientForm(client) {
			@Override
			protected void submit(Client client) {
				ClientController.update(client);
				hostView.dispose();
			}
		});
		
		this.display();
	}
}
