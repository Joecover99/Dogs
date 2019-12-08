package components;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {
	public final static String INVALID_DIALOG = "Certains champs n'ont pas de renseignement.";
	public final static String INVALID_DIALOG_TITLE = "Formulaire invalide";
	public final static String SUBMIT_ERROR_TITLE = "Érreur à la soumission du formulaire";
	public final static String CANNOT_FIND_ITEM_ERROR = "La fiche que vous tentez de consulter n'est pas disponible dans la base de donnée.";
	public final static String SUCCESS_DIALOG_TITLE = "Succes";
	public final static String SUBMIT_LABEL = "Enregistrer";
	
	public Form(Object[][] labelFieldList) {
		this.setLayout(new GridLayout(0, 1, 2, 2));
		
		for (Object[] field : labelFieldList) {
			this.add(new JExtLabeledComponent((String)field[0], (Component)field[1]));
		}
		
		this.add(new JExtButton(SUBMIT_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trySubmit();
			}
		}));
	}
	
	private void trySubmit() {
		if(this.checkValidity()) {
			this.submit();
		} else {
			JOptionPane.showMessageDialog(this, INVALID_DIALOG, INVALID_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected abstract void submit();
	protected abstract Boolean checkValidity();
}
