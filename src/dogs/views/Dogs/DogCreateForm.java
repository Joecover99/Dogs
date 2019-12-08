package dogs.views.Dogs;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Form;
import dogs.controllers.DogController;
import dogs.models.Client;
import dogs.models.Dog.Breed;
import dogs.models.IClient;

@SuppressWarnings("serial")
public class DogCreateForm extends JPanel {
	// Constexpr
	public final static String TITLE = "Inscrire un chien";
	public final static String NAME_LABEL = "Nom";
	public final static String BREED_LABEL = "Race";
	public final static String OWNER_LABEL = "Propriétaire";
	public final static String SUCCESS_DIALOGUE = "Le chien à été enregistrer avec succes. Considérer fermer rafraichir la fenêtre.";
	
	// Form fields
	final JTextField nameInputField;
	final JComboBox<Breed> breedInputField;
	final JComboBox<IClient> clientInputField;
	
	// Constructors
	public DogCreateForm(IClient[] clients) {
		this.setBorder(BorderFactory.createTitledBorder(TITLE));
		this.nameInputField = new JTextField();
		this.breedInputField = new JComboBox<Breed>(Breed.values());
		this.clientInputField = new JComboBox<IClient>(clients);
		
		Object[][] labelFieldList = new Object[][] {
			{ NAME_LABEL, nameInputField },
			{ BREED_LABEL, breedInputField},
			{ OWNER_LABEL, clientInputField}
		};
		
		this.add(new Form(labelFieldList) {
			
			@Override
			protected void submit() {
				DogController.store(nameInputField.getText(), (Breed) breedInputField.getSelectedItem(), (Client) clientInputField.getSelectedItem());
				JOptionPane.showMessageDialog(this, SUCCESS_DIALOGUE, Form.SUCCESS_DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
			}
			
			@Override
			protected Boolean checkValidity() {
				return !nameInputField.getText().isEmpty();
			}
		});
	}
}
