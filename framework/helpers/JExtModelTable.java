package helpers;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dogs.views.Clients.ClientEditView;
import interfaces.IModel;

@SuppressWarnings("serial")
public abstract class JExtModelTable<T extends IModel> extends JTable {
	
	protected final TableRowSorter<TableModel> sorter;
	
	public JExtModelTable(String[] columnNames, List<T> instances) {
		super();
		
		// Populate column
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		for (String columnName : columnNames) {
			model.addColumn(columnName);
		}
		
		// Disabling column reordoring because no one asked for this.
		this.getTableHeader().setReorderingAllowed(false);
		
		// Add the sorter to the table
		this.sorter = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sorter);
		
		// Sort on the first column to ensure order and make the sorting feature visible to the user.
		sorter.toggleSortOrder(0);
		
		for (T instance : instances) {
			model.addRow(this.generateRowObject(instance));
		}
		
		// Set selection mode to single because there's no "none" option. Again, no one asked to have this by default. 
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Add selection handler to replace the default broken one
		this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			// Latch variable to fix a problem with swift click event & table
			private Boolean isRowClickEventCausedByMouseRelease = false;
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Block the execution for next event-handling (which is a bug) and make the next one unlock it
				this.isRowClickEventCausedByMouseRelease = !isRowClickEventCausedByMouseRelease;
				
				if(this.isRowClickEventCausedByMouseRelease) {
					int selectedRowIndex = e.getFirstIndex();
					onRowClicked(selectedRowIndex);
					
				}
			}
		});
	}
	
	protected abstract Object[] generateRowObject(T object);
	protected void onRowClicked(final int rowIndex) { }
	
	// Disable cell editing because no one asked for this to be on by default
	@Override
	public boolean isCellEditable(int row, int column) { return false; }
}
