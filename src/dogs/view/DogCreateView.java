package dogs.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DogCreateView implements IView {

	private static final String DEFAULT_MODALITY_TYPE = null;
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
		this.setTitle(WelcomeView.VIEW_TITLE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		
	}
	


	private void setTitle(String viewTitle) {
		// TODO Auto-generated method stub
		
	}
	
	private void setModalityType(String defaultModalityType) {
		// TODO Auto-generated method stub
		
	}

	private void setVisible() {
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

	private void add(JPanel actionPanel, String south) {
		// TODO Auto-generated method stub
		
	}

	private void setUpInputDataPanel() {
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(0,2));
		
		this.addTextField(inputDataPanel, WelcomeView.LABEL_NAME ,this.name);
		this.addTextField(inputDataPanel, WelcomeView.LABEL_BREED ,this.breed);
	}
	
	private void add(JPanel inputDataPanel) {
		// TODO Auto-generated method stub
		
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
