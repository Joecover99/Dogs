package helpers;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JExtButton extends JButton {

	public JExtButton(String label, ActionListener onClick) {
		super(label);
		
		this.addActionListener(onClick);
	}

}
