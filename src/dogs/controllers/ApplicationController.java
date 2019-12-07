package dogs.controllers;

import abstracts.Controller;
import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.views.WelcomeView;
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
		
		new WelcomeView(clientRepository.select());
	}
}
