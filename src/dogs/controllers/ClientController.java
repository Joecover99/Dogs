package dogs.controllers;

import java.util.List;

import dogs.MainAppDogs;
import dogs.models.Client;
import dogs.views.Clients.ClientEditView;
import dogs.views.Clients.ClientIndexView;
import exceptions.ModelNotPersistedException;
import interfaces.IRepository;

public class ClientController {
	
	private static IRepository<Client> clientRepository = MainAppDogs.clientRepository;
	
	public static void index() {
		List<Client> clientList = clientRepository.selectAll();
		new ClientIndexView(clientList);
	}
	
	public static void edit(int clientId) throws ModelNotPersistedException {
		Client client = clientRepository.select(clientId);
		new ClientEditView(client);
	}
	
	public static void update(final int id, final String firstName, final String lastName, final String phoneNumber) throws ModelNotPersistedException {
		Client client = clientRepository.select(id);
		client.setFirstName(firstName);
		client.setName(lastName);
		client.setPhoneNumber(phoneNumber);
		clientRepository.update(client);
	}

	public static void store(final String firstName, final String lastName, final String phoneNumber) {
		clientRepository.insert(new Client(firstName, lastName, phoneNumber));
	}
}
