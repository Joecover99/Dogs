package dogs.view;

import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dogDTO.DogDTOForList;

public class DogListView {
	
	IDogController controller;
	Collection<DogDTOForList> listOfDogs;

	public DogListView(IDogController controller, Collection<DogDTOForList> dogDTOList) {
		super();
		
		this.controller = controller;
		this.listOfDogs = dogDTOList;
		
		this.initialize();
		this.setUpComponents();
		this.pack();
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	private initialize() {
		this.setTitle(VIEW_TITLE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	private void setUpComponents() {
		this.setUpDisplayDataPanel();
		this.SetUpActionPanel();
	}
	
	private void setUpDisplayPanel() {
		JPanel displayDataPanel = new JPanel();
		displayDataPanel.setBorder(new EmptyBorder(20,20,20,20));
		this.add(displayDataPanel);
		
		displayDataPanel.setLayout(new GridLayout(0,3));
		
		JLabel idLabelColum = new JLabel(LABEL_ID);
		displayDataPanel.add(idLabelColum);
		displayDataPanel.add(new JLabel(LABEL_NAME));
		displayDataPanel.add(new JLabel(LABEL_BREED));
		
		for(DogDTOForList dog:this.listOfDogs) {
			displayDataPanel.add(new JLabel(String.valueOf(dog.id)));
		}
	}
	
	private void setUpActionPanel() {
		
	}
		
	}
}
