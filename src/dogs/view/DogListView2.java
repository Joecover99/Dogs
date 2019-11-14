package dogs.view;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dogDTO.DogDTOForCreate;
import dogDTO.DogDTOForList;

public class DogListView2 implements IView{

	
	IDogController controller;
	Collection<DogDTOForList> listOfDogs;

	public DogListView2(IDogController controller, Collection<DogDTOForList> dogDTOlist) {
		super();
		
		this.controller = controller;
		this.listOfDogs = dogDTOlist;
		
		this.initialize();
		this.setUpComponents();
		this.pack();
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	private void setUpComponents() {
		this.setUpDisplayDataPanel();
		this.SetUpActionPanel();
	}
	
	private void setUpDisplayDataPanel() {
		JPanel displayDataPanel = new JPanel();
		displayDataPanel.setBorder(new EmptyBorder(20,20,20,20));
		this.add(displayDataPanel);
		
		String[] columnNames = {LABEL_ID, LABEL_NAME, LABEL_BREED};
		
		Object[][] data = new Object[this.listOfDogs.size()][3];
		
		int rowNb = 0;
		
		for(DogDTOForList dog:this.listOfDogs) {
			data[rowNb][0] = String.valueOf(dog.id);
			data[rowNb][1] = dog.name;
			data[rowNb][2] = dog.breed;
			rowNb++;
		}
		JTable table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		displayDataPanel.add(scrollPane);
	}
	
	private void SetUpActionPanel() {
		
	}
	
}
