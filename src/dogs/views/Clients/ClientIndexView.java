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
import dogs.views.Clients.components.ClientCreateForm;
import helpers.JExtButton;

public class ClientIndexView extends AbstractView {
	
	public final static String TITLE = "Gestion des clients";
	
	private List<Client> clients;
	
	// Constructors
	public ClientIndexView(List<Client> clients) {
		super(TITLE);
		this.setLayout(new BorderLayout(2, 2));
		this.clients = clients;
		
		this.add(new SearchByIdPane(), BorderLayout.NORTH);
		this.add(new ClientTablePanel(clients), BorderLayout.CENTER);
		this.add(new ClientCreateForm(), BorderLayout.SOUTH);
		
		this.display();
	}
	
	// Components
	private class SearchByIdPane extends JPanel {
		public final static String TITLE = "Rechercher un client par no.";
		
		public SearchByIdPane() {
			this.setBorder(BorderFactory.createTitledBorder(TITLE));
			
			JSpinner idInput = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			this.add(idInput);
			
			JExtButton confirmButton = new JExtButton("Go", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = (int)idInput.getValue();
					new ClientEditView(clients.get(id));
				}
			});
			
			this.add(confirmButton);
		}
	}
	
}
