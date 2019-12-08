package components;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Short class to label thing quickly
 * @author benbe
 *
 */
@SuppressWarnings("serial")
public class JExtLabeledComponent extends JPanel {
	public JExtLabeledComponent(final String label, final Component component) {
		this.setLayout(new GridLayout(1, 2));
		this.add(new JLabel(label));
		this.add(component);
	}
}
