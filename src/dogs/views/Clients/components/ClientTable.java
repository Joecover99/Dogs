package dogs.views.Clients.components;

import java.util.List;

import javax.swing.RowFilter;

import components.JExtModelTable;
import dogs.models.IClient;

/**
 * A sortable JTable of client with costume methods to apply filter on name fields 
 *
 */
@SuppressWarnings("serial")
public class ClientTable extends JExtModelTable<IClient> {
	
	// private static final int ID_COLUMN_INDEX = 0;
	private static final int FIRST_NAME_COLUMN_INDEX = 1;
	private static final int LAST_NAME_COLUMN_INDEX = 2;
	// private static final int PHONE_NUMBER_COLUMN_INDEX = 3;
	private static final String[] COLUMN_NAMES = { "Id", "FirstName", "LastName", "PhoneNumber" };
	
	public ClientTable(final List<IClient> clientList) {
		super(COLUMN_NAMES, clientList);
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
	public Object[] generateRowObject(IClient client) {
		return new Object[]{
			client.getId(),
			client.getFirstName(),
			client.getLastName(),
			client.getPhoneNumber()
		};
	}
	
}
