package dogs.views.Clients;

import abstracts.AbstractView;
import dogs.models.Client;
import dogs.views.Clients.components.ClientForm;

public class ClientEditView extends AbstractView {
	public final static String TITLE = "Modifier un client";
	
	public ClientEditView(Client client) {
		super(TITLE);
		
		this.add(new ClientForm(client) {
			@Override
			protected void submit(Client client) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.display();
	}
	
}
