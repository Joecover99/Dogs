package components;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JExtButton extends JButton {

	public JExtButton(String label, ActionListener onClick) {
		super(label);
		
		this.addActionListener(onClick);
	}

}
