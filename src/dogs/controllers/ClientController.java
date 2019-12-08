package dogs.controllers;

import java.util.List;

import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.views.Clients.ClientEditView;
import dogs.views.Clients.ClientIndexView;
import interfaces.IRepository;

public class ClientController {
	
	@SuppressWarnings("unchecked")
	private final static IRepository<Client> clientRepository = (IRepository<Client>) RepositoryManager.getModelRepository(Client.class);
	
	public static void index() {
		List<Client> clientList = clientRepository.select();
		new ClientIndexView(clientList);
	}
	
	public static void edit(int clientId) {
		Client client = clientRepository.select(clientId);
		new ClientEditView(client);
	}
	
	public static void store(Client client) {
		client.persist();
	}
	
	public static void update(Client client) {
		client.save();
	}
}
