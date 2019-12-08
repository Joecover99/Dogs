package dogs.views.Clients.components;

import java.awt.Cursor;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dogs.controllers.ClientController;
import dogs.models.Client;
import dogs.views.Clients.ClientEditView;
import helpers.JExtModelTable;

/**
 * A sortable JTable of client with costume methods to apply filter on name fields 
 *
 */
@SuppressWarnings("serial")
public class ClientTable extends JExtModelTable<Client> {
	
	private static final int ID_COLUMN_INDEX = 0;
	private static final int FIRST_NAME_COLUMN_INDEX = 1;
	private static final int LAST_NAME_COLUMN_INDEX = 2;
	// private static final int PHONE_NUMBER_COLUMN_INDEX = 3;
	private static final String[] COLUMN_NAMES = { "Id", "FirstName", "LastName", "PhoneNumber" };
	
	public ClientTable(final List<Client> clients) {
		super(COLUMN_NAMES, clients);
		
		// Setup appearance
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	@Override
	protected void onRowClicked(int rowIndex) {
		int id = (int)this.getValueAt(rowIndex, ID_COLUMN_INDEX);
		ClientController.edit(id);
	}
	
	public void setNameFilter(String value) {
		this.sorter.setRowFilter(new RowFilter<Object, Object>() {
			@Override
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				String firstName = (String)entry.getValue(FIRST_NAME_COLUMN_INDEX);
				String lastName = (String)entry.getValue(LAST_NAME_COLUMN_INDEX);
				return this.StringContainsCaseInsensitive(firstName, value) || this.StringContainsCaseInsensitive(lastName, value);
			}
			
			private Boolean StringContainsCaseInsensitive(String target, String pattern) {
				return target.toLowerCase().contains(pattern.toLowerCase());
			}
		});
	}

	@Override
	public Object[] generateRowObject(Client client) {
		return new Object[]{
			client.getId(),
			client.getFirstName(),
			client.getLastName(),
			client.getPhoneNumber()
		};
	}
	
}
