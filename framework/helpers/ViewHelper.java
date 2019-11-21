package helpers;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewHelper {
	public static JTextField addLabeledTextField(JPanel panel, final String labelText) {
		JTextField textField = new JTextField(25);
		JLabel label = new JLabel(labelText);
		
		panel.add(label);
		panel.add(textField);
		
		return textField;
	}
}
