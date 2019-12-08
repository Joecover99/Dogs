package components;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class View extends JFrame {
	public View(final String title) {
		super(title);
		this.setResizable(false);
	}
	
	public void display() {
		this.pack();
		this.setVisible(true);
	}
}
