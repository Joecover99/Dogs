package dogs.views.Clients.components;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.JExtLabeledComponent;
import dogs.models.IClient;

/**
 * The panel holding the ClientTable, the filter panel and more
 */
@SuppressWarnings("serial")
public class ClientTablePanel extends JPanel {
	public final static String LABEL_NAME_FILTER = "Filtrer par nom :";
	
	public static final String TITLE = "Trouver un client parmis la liste des clients";
	public ClientTablePanel(List<IClient> clientList) {
		super();
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
		this.setLayout(new BorderLayout(8, 8));
		
		ClientTable clientTable = new ClientTable(clientList);
		NameFilterInputField clientNameSearchField = new NameFilterInputField(clientTable);
		this.add(new JExtLabeledComponent(LABEL_NAME_FILTER, clientNameSearchField), BorderLayout.NORTH);
		this.add(new JScrollPane(clientTable), BorderLayout.CENTER);
	}
	

	/**
	 * A costumized text input used to change the name filter value on a given ClientTable
	 * @author benbe
	 *
	 */
	private class NameFilterInputField extends JTextField {
		
		private ClientTable clientTable;
		
		public NameFilterInputField(ClientTable clientTable) {
			super(LABEL_NAME_FILTER);
			this.clientTable = clientTable;
			
			// Add a simple listener to change the table's filter when the text field change
			this.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				@Override
				public void insertUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				@Override
				public void changedUpdate(DocumentEvent e) { this.noticeFilter(); }
				
				private void noticeFilter() { onChanged(); }
			});
		}
		
		private void onChanged() {
			clientTable.setNameFilter(this.getText());
		}
		
	}
}
