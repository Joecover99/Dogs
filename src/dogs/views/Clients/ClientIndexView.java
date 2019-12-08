package dogs.views.Clients;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import abstracts.AbstractView;
import dogs.models.Client;
import dogs.views.Clients.components.ClientTablePanel;
import dogs.views.SearchModelInstanceByIdPanel;
import dogs.views.Clients.components.ClientCreateForm;
import helpers.JExtButton;

@SuppressWarnings("serial")
public class ClientIndexView extends AbstractView {
	
	public final static String TITLE = "Gestion des clients";
	
	private List<Client> clients;
	
	// Constructors
	public ClientIndexView(List<Client> clients) {
		super(TITLE);
		this.setLayout(new BorderLayout(2, 2));
		this.clients = clients;
		
		this.add(new SearchClientByIdPane(clients.size() - 1), BorderLayout.NORTH);
		this.add(new ClientTablePanel(clients), BorderLayout.CENTER);
		this.add(new ClientCreateForm(), BorderLayout.SOUTH);
		
		this.display();
	}
	
	// Components
	private class SearchClientByIdPane extends SearchModelInstanceByIdPanel {
		public final static String TITLE = "Rechercher un client par no.";
		
		public SearchClientByIdPane(final int maxId) { super(TITLE, maxId); }
		
		@Override
		protected void onSelect(int id) {
			new ClientEditView(clients.get(id));
		}
	}
	
}
