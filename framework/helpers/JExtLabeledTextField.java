package helpers;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JExtLabeledTextField extends JPanel {
	private static final int DEFAULT_FIELD_LENGTH = 25;
	protected final JTextField field;
	
	public JExtLabeledTextField(final String label) {
		this(label, DEFAULT_FIELD_LENGTH);
	}
	
	public JExtLabeledTextField(final String label, final String text) {
		this(label);
		this.field.setText(text);
	}
	
	public JExtLabeledTextField(final String label, final int fieldLength) {
		super();
		this.field = new JTextField(fieldLength);
		
		this.add(new JExtLabeledComponent(label, this.field));
	}
	
	public String getText() {
		return this.field.getText();
	}
	
	public Boolean isEmpty() {
		return this.getText().isEmpty();
	}
}