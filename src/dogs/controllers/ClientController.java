package dogs.controllers;

import java.util.List;

import dogs.MainAppDogs;
import dogs.models.Client;
import dogs.models.IClient;
import dogs.views.Clients.ClientEditView;
import dogs.views.Clients.ClientIndexView;
import exceptions.ModelNotPersistedException;
import interfaces.IRepository;

public class ClientController {
	
	private static IRepository<IClient> clientRepository = MainAppDogs.clientRepository;
	
	public static void index() {
		List<IClient> clientList = clientRepository.selectAll();
		new ClientIndexView(clientList);
	}
	
	public static void edit(int clientId) throws ModelNotPersistedException {
		IClient client = clientRepository.select(clientId);
		new ClientEditView(client);
	}
	
	public static void update(final int id, final String firstName, final String lastName, final String phoneNumber) throws ModelNotPersistedException {
		IClient client = clientRepository.select(id);
		client.setFirstName(firstName);
		client.setName(lastName);
		client.setPhoneNumber(phoneNumber);
		clientRepository.update(client);
	}

	public static void store(final String firstName, final String lastName, final String phoneNumber) {
		clientRepository.insert(new Client(firstName, lastName, phoneNumber));
	}
}
