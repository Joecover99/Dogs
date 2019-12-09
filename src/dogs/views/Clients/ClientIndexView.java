package dogs.views.Clients;

import java.awt.BorderLayout;
import java.util.List;

import components.View;
import dogs.models.IClient;
import dogs.views.Clients.components.ClientTablePanel;
import dogs.views.SearchModelInstanceByIdPanel;
import dogs.views.Clients.components.ClientCreateForm;

@SuppressWarnings("serial")
public class ClientIndexView extends View {
	
	public final static String TITLE = "Gestion des clients";
	
	private List<IClient> clients;
	
	// Constructors
	public ClientIndexView(List<IClient> clientList) {
		super(TITLE);
		this.setLayout(new BorderLayout(2, 2));
		this.clients = clientList;
		
		this.add(new SearchClientByIdPane(clientList.size() - 1), BorderLayout.NORTH);
		this.add(new ClientTablePanel(clientList), BorderLayout.CENTER);
		this.add(new ClientCreateForm(), BorderLayout.SOUTH);
		
		this.display();
	}
	
	// Components
	private class SearchClientByIdPane extends SearchModelInstanceByIdPanel {
		public final static String TITLE = "Rechercher un client par no.";
		
		public SearchClientByIdPane(final int maxId) { super(TITLE); }
		
		@Override
		protected void onSelect(int id) {
			new ClientEditView(clients.get(id));
		}
	}
	
}
