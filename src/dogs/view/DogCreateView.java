package dogs.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DogCreateView implements IView {

	private IDogController controller;
	private JTextField name;
	private JTextField breed;

	public DogCreateView(IDogController controller) {
		super();
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
		this.pack();
	}
	
	private void pack() {
		// TODO Auto-generated method stub
		
	}

	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		
	}
	
	private void setVisibles() {
		// TODO Auto-generated method stub
		
	}

	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();
	}
	
	private void setUpActionPanel() {
		// TODO Auto-generated method stub
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
	}

	private void setUpInputDataPanel() {
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(0,2));
		
		this.addTextField(inputDataPanel, LABEL_NAME ,this.name);
		this.addTextField(inputDataPanel, LABEL_BREED ,this.breed);
	}
	
	private void addTextField(JPanel panel, String labelText, JTextField textField) {
		panel.add(new JLabel(labelText));
		panel.add(textField);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	

}
