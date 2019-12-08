package dogs.views.Dogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import components.Form;
import components.JExtButton;
import components.View;
import dogs.controllers.DogController;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import exceptions.ModelNotPersistedException;

@SuppressWarnings("serial")
public class DogEditView extends View {
	
	// Constexpr
	public final static String TITLE = "Modifier un chien";
	public final static String DELETE_LABEL = "Suprimer cette fiche";
	public final static String DELETE_DIALOG_PROMPT = "Voulez-vous supprimer cette fiche?";
	public final static String DELETE_SUCCESS_DIALOG_MESSAGE = "La fiche à été suprimer.";
	public final static String DELETE_DIALOG_TITLE = "Confirmation";
	public final static String EDIT_SUCCESS_DIALOGUE = "La fiche à été modifier avec succes";
	public final static int DELETE_DIALOG_CONFIRM_VALUE = 0;
	public final static String[] DELETE_DIALOG_OPTION = new String[] { "Oui", "Non" };
	
	// Form fields
	private JTextField nameInputField;
	private JComboBox<Breed> breedInputField;
	
	// Constructors
	public DogEditView(Dog dog) {
		super(TITLE);
		this.setLayout(new BorderLayout(4, 4));
		JPanel mainPanel = new JPanel() {
			{
				this.setLayout(new BorderLayout(4, 4));
				setBorder(new EmptyBorder(8, 8, 8, 8));
			}
		};
		
		this.nameInputField = new JTextField(dog.getName());
		this.breedInputField = new JComboBox<Breed>(Breed.values());
		this.breedInputField.setSelectedItem(dog.getBreed());
		
		Object[][] labelFieldList = new Object[][] {
			{ DogCreateForm.NAME_LABEL, nameInputField },
			{ DogCreateForm.BREED_LABEL, breedInputField},
		};
		
		mainPanel.add(new Form(labelFieldList) {
			
			@Override
			protected void submit() {
				try {
					DogController.update(dog.getId(), nameInputField.getText(), (Breed) breedInputField.getSelectedItem());
					JOptionPane.showMessageDialog(this, EDIT_SUCCESS_DIALOGUE, Form.SUCCESS_DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
				} catch (ModelNotPersistedException e) {
					JOptionPane.showMessageDialog(this, Form.CANNOT_FIND_ITEM_ERROR, Form.SUBMIT_ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
				}
			}
			
			@Override
			protected Boolean checkValidity() {
				return !nameInputField.getText().isEmpty();
			}
		}, BorderLayout.NORTH);
		
		mainPanel.add(new JSeparator());
		JExtButton deleteButton = new JExtButton(DELETE_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 int confirmed = JOptionPane.showOptionDialog(
						 mainPanel,							// parentComponent
						 DELETE_DIALOG_PROMPT,			// message
						 DELETE_DIALOG_TITLE,			// title
						 JOptionPane.YES_NO_OPTION,		// optionType
						 JOptionPane.WARNING_MESSAGE,	// messageType
						 null,							// icon
						 DELETE_DIALOG_OPTION,			// options
						 DELETE_DIALOG_OPTION[1]);		// initialValue
				 
				 if(confirmed == DELETE_DIALOG_CONFIRM_VALUE) {
					 try {
						 DogController.delete(dog);
						 JOptionPane.showMessageDialog(mainPanel, DELETE_SUCCESS_DIALOG_MESSAGE, Form.SUCCESS_DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
						 ((Window) SwingUtilities.getRoot(mainPanel)).dispose();
					 } catch (ModelNotPersistedException e1) {
						 JOptionPane.showMessageDialog(mainPanel, Form.CANNOT_FIND_ITEM_ERROR, Form.SUBMIT_ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
					 }
				 }
			}
		});
		deleteButton.setBackground(Color.PINK);
		mainPanel.add(deleteButton, BorderLayout.SOUTH);
		
		this.add(mainPanel);
		
		this.display();
	}
}
