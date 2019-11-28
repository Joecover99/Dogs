package dogs.controllers;

import java.util.Collection;
import java.util.Comparator;

import abstracts.Controller;
import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.views.Clients.ClientIndexView;
import dogs.views.Clients.ClientShowView;
import interfaces.IRepository;

public class ClientController extends Controller<Client> {
	
	final IRepository<Client> clientRepository;
	
	@SuppressWarnings("unchecked")
	ClientController() {
		this.clientRepository = (IRepository<Client>) RepositoryManager.getModelRepository(Client.class);
	}
	
	protected void index(Object argument) {
		@SuppressWarnings("unchecked")
		Comparator<Client> sortComparator = (Comparator<Client>)argument;
		Collection<Client> clientList = this.clientRepository.select(sortComparator);
		
		new ClientIndexView(clientList);
	}
	
	@Override
	protected void show(Object arguments)  {
		int id = (int)arguments;
		Client client = this.clientRepository.select(id);
		
		new ClientShowView(client);
	}
	
	public static final class ClientComparator {
		private ClientComparator() {}
		
		public final static Comparator<Client> byLastName = new Comparator<Client>() {
			@Override
			public int compare(Client c1, Client c2) {
				return c1.getLastName().compareTo(c2.getLastName());
			}
		};
		
		public final static Comparator<Client> byPhoneNumber = new Comparator<Client>() {
			@Override
			public int compare(Client c1, Client c2) {
				return c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
			}
		};
	}
}
