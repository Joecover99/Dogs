package dogs.views.Dogs;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import abstracts.AbstractView;
import dogs.models.Dog;

public class DogIndexView extends AbstractView {
	public final static String TITLE = "Dog list";
	static final String[] COLUMN_NAMES = { "Id", "Name", "Breed" };

	public DogIndexView(Collection<Dog> dogs) {
		super();
		
		this.add(new DisplayDataPanel(dogs));
	}
	
	private class DisplayDataPanel extends JPanel {
		
		public DisplayDataPanel(Collection<Dog> dogs) {
			super();
			this.setBorder(new EmptyBorder(20,20,20,20));
			
			Object[][] data = new Object[dogs.size()][COLUMN_NAMES.length];
			
			int rowNb = 0;
			for(Dog dog : dogs) {
				data[rowNb][0] = String.valueOf(dog.getId());
				data[rowNb][1] = dog.getName();
				data[rowNb][2] = dog.getBreed();
				rowNb++;
			}
			
			JTable table = new JTable(data, COLUMN_NAMES);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			this.add(scrollPane);
		}
	}
}
