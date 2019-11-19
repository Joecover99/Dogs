package dogs.view;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dogDTO.DogDTOForList;

public class DogListView {
	
	public static final String LABEL_ID = null;
	private static final String DEFAULT_MODALITY_TYPE = null;
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
	
	private void pack() {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		this.setVisible(true);
	}
	


	private void initialize() {
		this.setTitle(WelcomeView.VIEW_TITLE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	private void setModalityType(String defaultModalityType) {
		// TODO Auto-generated method stub
		
	}

	private void setTitle(String viewTitle) {
		// TODO Auto-generated method stub
		
	}
	
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setUpComponents() {
		this.setUpDisplayDataPanel();
		this.setUpActionPanel();
	}
	
	private void setUpDisplayDataPanel() {
		JPanel displayDataPanel = new JPanel();
		displayDataPanel.setBorder(new EmptyBorder(20,20,20,20));
		this.add(displayDataPanel);
		
		displayDataPanel.setLayout(new GridLayout(0,3));
		
		JLabel idLabelColum = new JLabel(LABEL_ID);
		displayDataPanel.add(idLabelColum);
		displayDataPanel.add(new JLabel(WelcomeView.LABEL_NAME));
		displayDataPanel.add(new JLabel(WelcomeView.LABEL_BREED));
		
		for(DogDTOForList dog:this.listOfDogs) {
			displayDataPanel.add(new JLabel(String.valueOf(dog.id)));
		}
	}
	
	private void add(JPanel displayDataPanel) {
		// TODO Auto-generated method stub
		
	}

	private void setUpActionPanel() {
		
	}
		
}
