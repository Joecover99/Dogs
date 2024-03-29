package dogs.views.Dogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;

import components.Form;
import components.JExtLabeledComponent;
import components.JExtModelTable;
import components.View;
import dogs.controllers.DogController;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import dogs.models.IClient;
import dogs.views.SearchModelInstanceByIdPanel;
import exceptions.ModelNotPersistedException;

@SuppressWarnings("serial")
public class DogIndexView extends View {
	public final static String TITLE = "Gestion des chiens";

	public DogIndexView(List<Dog> dogs, IClient[] clients) {
		super(TITLE);
		this.setLayout(new BorderLayout(2, 2));
		this.add(new SearchDogByIdForm(dogs.size() - 1), BorderLayout.NORTH);
		this.add(new DogTableSection(dogs), BorderLayout.CENTER);
		this.add(new DogCreateForm(clients), BorderLayout.SOUTH);
		this.display();
	}
	
	private static class DogTableSection extends JPanel {
		public final static String TITLE = "List de chien";
		public final static String BREED_LABEL = "Race";
		
		public DogTableSection(List<Dog> dogs) {
			super();
			this.setBorder(BorderFactory.createTitledBorder(TITLE));
			this.setLayout(new BorderLayout(8, 8));
			
			DogTable dogTable = new DogTable(dogs);
			BreedFilterInputField breedFilterField = new BreedFilterInputField(dogTable);
			this.add(new JExtLabeledComponent(BREED_LABEL, breedFilterField), BorderLayout.NORTH);
			this.add(new JScrollPane(dogTable), BorderLayout.CENTER);
		}
		
	}
	
	private static class BreedFilterInputField extends JComboBox<Dog.Breed> implements ActionListener {
		private final DogTable dogTable;
		public BreedFilterInputField(DogTable dogTable) {
			super(Dog.Breed.values());
			this.dogTable = dogTable;
			this.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Breed breed = (Breed) this.getSelectedItem();
			this.dogTable.setBreedFilter(breed);
	    }
	}
	
	private static class DogTable extends JExtModelTable<Dog> {
		private static final int BREED_COLUMN_INDEX = 2;
		private static final String[] COLUMNS_NAMES = { "Id", "Nom", "Race", "Propriétaire" };
		
		public DogTable(List<Dog> dogs) {
			super(COLUMNS_NAMES, dogs);
		}

		public void setBreedFilter(Breed breed) {
			this.sorter.setRowFilter(new RowFilter<Object, Object>() {
				@Override
				public boolean include(Entry<? extends Object, ? extends Object> entry) {
					return (String)entry.getValue(BREED_COLUMN_INDEX) == breed.toString();
				}
			});
		}

		@Override
		public Object[] generateRowObject(Dog dog) {
			return new Object[] {
				dog.getId(),
				dog.getName(),
				dog.getBreed().toString(),
				dog.getOwnerName()
			};
		}
	}
	
	private class SearchDogByIdForm extends SearchModelInstanceByIdPanel {
		public final static String TITLE = "Rechercher un chien par no.";
		public SearchDogByIdForm(int maxId) {
			super(TITLE);
		}

		@Override
		protected void onSelect(int id) {
			try {
				DogController.edit(id);
			} catch (ModelNotPersistedException e) {
				JOptionPane.showMessageDialog(this, Form.CANNOT_FIND_ITEM_ERROR, Form.SUBMIT_ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
