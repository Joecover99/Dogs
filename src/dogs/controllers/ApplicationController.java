package dogs.controllers;

import java.util.ArrayList;

import abstracts.Controller;
import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.views.Clients.ClientIndexView;
import interfaces.IRepository;

@SuppressWarnings("rawtypes")
public class ApplicationController extends Controller {

	/**
	 * @since Exercice 4, step 1
	 */
	@Override
	protected void index(Object arguments) {
		@SuppressWarnings("unchecked")
		IRepository<Client> clientRepository = (IRepository<Client>) RepositoryManager.getModelRepository(Client.class);
		
		//new WelcomeView();
		
		ArrayList<Client> clients = new ArrayList<Client>() {
			{
				add(new Client("Albert", "Doe", "999-999-9999") {
					{
						setId(0);
					}
				});
				add(new Client("Gilbert", "Doe", "999-999-9999") {
					{
						setId(1);
					}
				});
				add(new Client("Robert", "Doe", "999-999-9999") {
					{
						setId(2);
					}
				});
				add(new Client("Kobert", "Doe", "999-999-9999") {
					{
						setId(3);
					}
				});
			}
		};
		
		new ClientIndexView(clients);
	}
}
