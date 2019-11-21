package helpers;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JExtLabeledTextField extends JPanel {
	private final JTextField field;
	
	public JExtLabeledTextField(final String label) {
		super();
		this.setLayout(new GridLayout(0, 2));
		this.field = new JTextField(25);
		
		this.add(new JLabel(label));
		this.add(field);
	}
	
	public String getText() {
		return this.field.getText();
	}
}
