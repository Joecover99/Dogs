package dogs.views.Clients.components;

import java.awt.Cursor;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dogs.models.Client;
import dogs.views.Clients.ClientEditView;
import helpers.JExtSortableTable;

/**
 * A sortable JTable of client with costume methods to apply filter on name fields 
 *
 */
public class ClientTable extends JExtSortableTable {
	
	private static final int ID_COLUMN_INDEX = 0;
	private static final int FIRST_NAME_COLUMN_INDEX = 1;
	private static final int LAST_NAME_COLUMN_INDEX = 2;
	// private static final int PHONE_NUMBER_COLUMN_INDEX = 3;
	private static final String[] COLUMN_NAMES = { "Id", "FirstName", "LastName", "PhoneNumber" };
	
	public ClientTable(final List<Client> clients) {
		super(COLUMN_NAMES);
		
		// Populate table
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		for(Client client : clients) {
			model.addRow(new Object[] {
				client.getId(),
				client.getFirstName(),
				client.getLastName(),
				client.getPhoneNumber()
			});
		}
		
		
		ClientTable thisTable = this;
		// Setup selection behaviour and appearance
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			// Latch variable to fix a problem with swift click event & table
			private Boolean isRowClickEventCausedByMouseRelease = false;
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Block the execution for next event-handling (which is a bug) and make the next one unlock it
				this.isRowClickEventCausedByMouseRelease = !isRowClickEventCausedByMouseRelease;
				
				if(this.isRowClickEventCausedByMouseRelease) {
					int selectedRowIndex = e.getFirstIndex();
					int selectedClientId = (int)thisTable.getValueAt(selectedRowIndex, ID_COLUMN_INDEX);
					
					new ClientEditView(clients.get(selectedClientId));
				}
			}
		});
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
	
}
