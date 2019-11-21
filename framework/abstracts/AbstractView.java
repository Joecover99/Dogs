package abstracts;

import javax.swing.JFrame;

import interfaces.IView;

public abstract class AbstractView extends JFrame implements IView {
	public final static String TITLE = null;
	
	public AbstractView() {
		super(TITLE);
	}
	
	public void display() {
		this.pack();
		this.setVisible(true);
	}
}
