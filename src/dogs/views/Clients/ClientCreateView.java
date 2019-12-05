package dogs.views.Clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import helpers.JExtButton;
import helpers.JExtLabeledTextField;

public class ClientCreateView extends JPanel {
	final static String FIRSTNAME_LABEL = "Prénom";
	final static String LASTNAME_LABEL = "Nom";
	final static String PHONE_NUMBER_LABEL = "Numéro de télephone";
	final static String SUBMIT_LABEL = "Enregistrer";
	
	public ClientCreateView() {
		final JExtLabeledTextField firstNameInput = new JExtLabeledTextField(FIRSTNAME_LABEL);
		final JExtLabeledTextField lastNameInput = new JExtLabeledTextField(LASTNAME_LABEL);
		final JExtLabeledTextField phoneNumberInput = new JExtLabeledTextField(PHONE_NUMBER_LABEL);
		this.add(firstNameInput);
		this.add(lastNameInput);
		this.add(phoneNumberInput);
		
		final JExtButton submitButton = new JExtButton(SUBMIT_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(firstNameInput.getin)
			}
		});
		
		this.add(submitButton);
	}
}
