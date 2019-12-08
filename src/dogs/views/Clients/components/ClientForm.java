package dogs.views.Clients.components;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Form;
import dogs.models.Client;

/**
 * A form shared by the client edit form and client creation form
 */
@SuppressWarnings("serial")
public abstract class ClientForm extends JPanel {
	public final static String FIRSTNAME_LABEL = "Prénom";
	public final static String LASTNAME_LABEL = "Nom";
	public final static String PHONE_NUMBER_LABEL = "Numéro de téléphone";
	public final static String SUBMIT_LABEL = "Enregistrer";
	public final static String INVALID_INPUT_LABEL = "Veuillez remplire tous les champs.";
	
	public final static String SUCCESS_LABEL = "Les données on été enregistrer avec succès. Considérer fermer puis re-ouvrir la list des clients.";
	
	private final JTextField firstNameInput;
	private final JTextField lastNameInput;
	private final JTextField phoneNumberInput;
	
	// Constructors
	public ClientForm() {
		this(new Client("", "", ""));
	}
	
	public ClientForm(Client client) {
		this.firstNameInput = new JTextField(client.getFirstName());
		this.lastNameInput = new JTextField(client.getLastName());
		this.phoneNumberInput = new JTextField(client.getPhoneNumber());
		
		Object[][] labeledFieldList = new Object[][] {
			{ FIRSTNAME_LABEL, this.firstNameInput },
			{ LASTNAME_LABEL, this.lastNameInput },
			{ PHONE_NUMBER_LABEL, this.phoneNumberInput }
		};
		
		this.add(new Form(labeledFieldList) {
			@Override
			protected void submit() {
				onSubmit(firstNameInput.getText(), lastNameInput.getText(), phoneNumberInput.getText());
				JOptionPane.showMessageDialog(this, SUCCESS_LABEL);
			}
			
			@Override
			protected Boolean checkValidity() {
				return !(firstNameInput.getText().isEmpty() || lastNameInput.getText().isEmpty() || phoneNumberInput.getText().isEmpty());
			}
		});
	}
	
	protected abstract void onSubmit(final String firstName, final String lastName, final String phoneNumber);
}