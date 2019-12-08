package helpers;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JExtSortableTable extends JTable {
	
	protected final TableRowSorter<TableModel> sorter;
	
	public JExtSortableTable(String[] columnNames) {
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
	}
	
	// Disable cell editing because no one asked for this to be on by default
	@Override
	public boolean isCellEditable(int row, int column) { return false; }
}
