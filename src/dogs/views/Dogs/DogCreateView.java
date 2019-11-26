package dogs.views.Dogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import abstracts.AbstractView;
import abstracts.Controller.Verb;
import dogs.controllers.DogController;
import dogs.models.Dog;
import helpers.ApplicationRouting;
import helpers.JExtButton;
import helpers.JExtLabeledTextField;

public class DogCreateView extends AbstractView {
	public final static String TITLE = "Inscription d'un chien";
	public final static String LABEL_NAME_FIELD = "Nom:";
	public final static String LABEL_BREED_FIELD = "Race:";
	public final static String LABEL_SUMBIT = "Inscrire";

	private JExtLabeledTextField nameField;
	private JExtLabeledTextField breedField;
	private AbstractView view = this;

	public DogCreateView() {
		super();
		
		this.nameField = new JExtLabeledTextField(LABEL_NAME_FIELD);
		this.breedField = new JExtLabeledTextField(LABEL_BREED_FIELD);
		
		SubmitPanel submitPanel = new SubmitPanel();
		
		this.add(nameField, BorderLayout.NORTH);
		this.add(breedField, BorderLayout.CENTER);
		this.add(submitPanel, BorderLayout.SOUTH);
		
		this.display();
	}
	
	private class SubmitPanel extends JPanel {
		public SubmitPanel() {
			super();
			
			JExtButton submitButton = new JExtButton(LABEL_SUMBIT, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ApplicationRouting.invoke(DogController.class, Verb.Store, new Dog(nameField.getText(), null));
					view.dispose();
				}
			});
			
			this.add(submitButton);
		}
	}
}
