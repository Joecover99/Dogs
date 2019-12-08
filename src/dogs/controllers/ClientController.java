package dogs.controllers;

import java.util.List;

import abstracts.Controller;
import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.views.Clients.ClientEditView;
import dogs.views.Clients.ClientIndexView;
import exceptions.UnimplementedRouteException;
import interfaces.IRepository;

public class ClientController extends Controller<Client> {
	
	final IRepository<Client> clientRepository;
	
	@SuppressWarnings("unchecked")
	ClientController() {
		this.clientRepository = (IRepository<Client>) RepositoryManager.getModelRepository(Client.class);
	}
	
	@Override
	protected void index(Object argument) {
		List<Client> clientList = this.clientRepository.select();
		new ClientIndexView(clientList);
	}
	
	@Override
	protected void edit(Object argument) throws UnimplementedRouteException {
		int clientId = (int) argument;
		Client client = this.clientRepository.select(clientId);
		
		new ClientEditView(client);
	}
}
