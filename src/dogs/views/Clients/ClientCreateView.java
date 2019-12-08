package dogs.views.Clients;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Form;
import dogs.controllers.ClientController;

@SuppressWarnings("serial")
public class ClientCreateView extends JPanel {
	final static String FIRSTNAME_LABEL = "Prénom";
	final static String LASTNAME_LABEL = "Nom";
	final static String PHONE_NUMBER_LABEL = "Numéro de télephone";
	final static String SUBMIT_LABEL = "Enregistrer";
	
	final static String SUCCESS_LABEL = "Client enregistré.";
	
	public ClientCreateView() {
		this.setLayout(new GridLayout(4, 1, 2, 2));
		
		final JTextField firstNameInput = new JTextField();
		final JTextField lastNameInput = new JTextField();
		final JTextField phoneNumberInput = new JTextField();
		
		Object[][] labelFieldList = new Object[][] {
			{FIRSTNAME_LABEL, firstNameInput},
			{LASTNAME_LABEL, lastNameInput},
			{PHONE_NUMBER_LABEL, phoneNumberInput}
		};
		
		this.add(new Form(labelFieldList) {
			
			@Override
			protected void submit() {
				ClientController.store(firstNameInput.getText(), lastNameInput.getText(), phoneNumberInput.getText());
				JOptionPane.showMessageDialog(this, SUCCESS_LABEL);
			}
			
			@Override
			protected Boolean checkValidity() {
				return !firstNameInput.getText().isEmpty() && !lastNameInput.getText().isEmpty() && !phoneNumberInput.getText().isEmpty();
			}
		});
	}
}
