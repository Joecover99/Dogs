package dogs.views;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dogs.models.Client;

public class ClientView extends JPanel {

	public final static String TITLE = "Client list";
	
	public final static String SORT_LABEL_BY_ID = "Sort by id";
	public final static String SORT_LABEL_BY_FIRST_NAME = "Sort by first Name";
	public final static String SORT_LABEL_BY_LAST_NAME = "Sort by last Name";
	public final static String SORT_LABEL_BY_PHONE_NUMBER = "Sort by phone number";
	
	static final String[] COLUMN_NAMES = { "Id", "FirstName", "LastName", "PhoneNumber" };

	
	public ClientView(Collection<Client> clients) {
		super();
		
		this.add(new DisplayDataPanel(clients));
	}
	
	private class DisplayDataPanel extends JPanel {
		public DisplayDataPanel(Collection<Client> clients) {
			super();
			this.setBorder(new EmptyBorder(20,20,20,20));
			
			Object[][] data = new Object[clients.size()][COLUMN_NAMES.length];
			
			int rowNb = 0;
			for(Client client : clients) {
				data[rowNb][0] = String.valueOf(client.getId());
				data[rowNb][1] = client.getFirstName();
				data[rowNb][2] = client.getLastName();
				data[rowNb][3] = client.getPhoneNumber();
				rowNb++;
			}
			
			JTable table = new JTable(data, COLUMN_NAMES);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			this.add(scrollPane);
		}

	}
	
}
