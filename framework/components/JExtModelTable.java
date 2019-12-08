package components;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		
		// Add the sorter to the table
		this.sorter = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sorter);
		// Sort on the first column to ensure order and make the sorting feature visible to the user.
		sorter.toggleSortOrder(0);
		
		for (T instance : instances) {
			model.addRow(this.generateRowObject(instance));
		}
	}
	
	protected abstract Object[] generateRowObject(T object);
	
	// Disable cell editing because no one asked for this to be on by default
	@Override
	public boolean isCellEditable(int row, int column) { return false; }
}
