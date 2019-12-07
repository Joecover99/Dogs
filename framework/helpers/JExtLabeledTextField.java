package helpers;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JExtLabeledTextField extends JPanel {
	private static final int DEFAULT_FIELD_LENGTH = 25;
	private final JTextField field;
	
	public JExtLabeledTextField(final String label) {
		this(label, DEFAULT_FIELD_LENGTH);
	}
	public JExtLabeledTextField(final String label, final int fieldLength) {
		super();
		this.setLayout(new GridLayout(0, 2));
		this.field = new JTextField(fieldLength);
		
		this.add(new JLabel(label));
		this.add(field);
	}
	
	public String getText() {
		return this.field.getText();
	}
	
	public Boolean isEmpty() {
		return this.getText().isEmpty();
	}
}