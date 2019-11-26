package abstracts;

import javax.swing.JFrame;

import interfaces.IView;

public abstract class AbstractView extends JFrame implements IView {
	public AbstractView() {
		this(null);
	}
	public AbstractView(final String title) {
		super(title);
	}
	
	public void display() {
		this.pack();
		this.setVisible(true);
	}
}
