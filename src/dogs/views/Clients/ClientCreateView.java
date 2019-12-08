package dogs.views.Clients;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dogs.models.Client;
import helpers.JExtButton;
import helpers.JExtLabeledTextField;

@SuppressWarnings("serial")
public class ClientCreateView extends JPanel {
	final static String FIRSTNAME_LABEL = "Prénom";
	final static String LASTNAME_LABEL = "Nom";
	final static String PHONE_NUMBER_LABEL = "Numéro de télephone";
	final static String SUBMIT_LABEL = "Enregistrer";
	
	final static String SUCCESS_LABEL = "Client enregistré.";
	
	public ClientCreateView() {
		this.setLayout(new GridLayout(4, 1, 2, 2));
		
		final JExtLabeledTextField firstNameInput = new JExtLabeledTextField(FIRSTNAME_LABEL);
		final JExtLabeledTextField lastNameInput = new JExtLabeledTextField(LASTNAME_LABEL);
		final JExtLabeledTextField phoneNumberInput = new JExtLabeledTextField(PHONE_NUMBER_LABEL);
		this.add(firstNameInput);
		this.add(lastNameInput);
		this.add(phoneNumberInput);
		
		final Component parentOfDialogue = this;
		final JExtButton submitButton = new JExtButton(SUBMIT_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!firstNameInput.isEmpty() && !lastNameInput.isEmpty() && !phoneNumberInput.isEmpty()) {
					Client newClient = new Client(firstNameInput.getText(), lastNameInput.getText(), phoneNumberInput.getText());
					newClient.persist();
					JOptionPane.showMessageDialog(parentOfDialogue, SUCCESS_LABEL);
				}
			}
		});
		
		this.add(submitButton);
	}
}
