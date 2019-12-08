package abstracts;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame {


	public AbstractView() {
		this(null);
	}
	public AbstractView(final String title) {
		super(title);
	}
	
	public void display() {
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
