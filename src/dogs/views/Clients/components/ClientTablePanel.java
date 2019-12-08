package dogs.views.Clients.components;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dogs.models.Client;
import helpers.JExtLabeledTextField;

/**
 * The panel holding the ClientTable, the filter panel and more
 */
public class ClientTablePanel extends JPanel {
	public final static String LABEL_NAME_FILTER = "Filtrer par nom :";
	
	public static final String TITLE = "Trouver un client parmis la liste des clients";
	public ClientTablePanel(List<Client> clients) {
		super();
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
		this.setLayout(new BorderLayout(8, 8));
		
		ClientTable clientTable = new ClientTable(clients);
		NameFilterInputField clientNameSearchField = new NameFilterInputField(clientTable);
		this.add(clientNameSearchField, BorderLayout.NORTH);
		this.add(new JScrollPane(clientTable), BorderLayout.CENTER);
	}
	

	/**
	 * A costumized text input used to change the name filter value on a given ClientTable
	 * @author benbe
	 *
	 */
	@SuppressWarnings("serial")
	private class NameFilterInputField extends JExtLabeledTextField {
		public NameFilterInputField(ClientTable clientTable) {
			super(LABEL_NAME_FILTER);
			
			// Add a simple listener to change the table's filter when the text field change
			this.field.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				@Override
				public void insertUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				@Override
				public void changedUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				private void noticeFilter() {
					clientTable.setNameFilter(field.getText());
				}
			});
		}
	}
}
