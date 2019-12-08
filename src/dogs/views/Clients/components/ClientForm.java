package dogs.views.Clients.components;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dogs.models.Client;
import helpers.JExtButton;
import helpers.JExtLabeledTextField;

/**
 * A form shared by the client edit form and client creation form
 */
public abstract class ClientForm extends JPanel {
	public final static String FIRSTNAME_LABEL = "Prénom";
	public final static String LASTNAME_LABEL = "Nom";
	public final static String PHONE_NUMBER_LABEL = "Numéro de téléphone";
	public final static String SUBMIT_LABEL = "Enregistrer";
	public final static String INVALID_INPUT_LABEL = "Veuillez remplire tous les champs.";
	
	public final static String SUCCESS_LABEL = "Les données on été enregistrer avec succès.";
	
	private final JExtLabeledTextField firstNameInput;
	private final JExtLabeledTextField lastNameInput;
	private final JExtLabeledTextField phoneNumberInput;
	
	// Constructors
	public ClientForm() {
		this(new Client("", "", ""));
	}
	
	public ClientForm(Client client) {
		this.setLayout(new GridLayout(4, 1, 2, 2));
		
		this.firstNameInput = new JExtLabeledTextField(FIRSTNAME_LABEL, client.getFirstName());
		this.lastNameInput = new JExtLabeledTextField(LASTNAME_LABEL, client.getLastName());
		this.phoneNumberInput = new JExtLabeledTextField(PHONE_NUMBER_LABEL, client.getPhoneNumber());
		this.add(this.firstNameInput);
		this.add(this.lastNameInput);
		this.add(this.phoneNumberInput);
		
		final Component parentOfDialogue = this;
		final JExtButton submitButton = new JExtButton(SUBMIT_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(areEnteredValuesValid()) {
					client.setFirstName(firstNameInput.getText());
					client.setName(lastNameInput.getText());
					client.setPhoneNumber(phoneNumberInput.getText());
					submit(client);
					JOptionPane.showMessageDialog(parentOfDialogue, SUCCESS_LABEL);
				} else {
					JOptionPane.showMessageDialog(parentOfDialogue, INVALID_INPUT_LABEL);
				}
			}
		});
		
		this.add(submitButton);
	}
	
	private Boolean areEnteredValuesValid() {
		return !(this.firstNameInput.isEmpty() || this.lastNameInput.isEmpty() || this.phoneNumberInput.isEmpty());
	}
	
	protected abstract void submit(final Client client);
}