package dogs.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import abstracts.AbstractView;
import dogs.controllers.DogController;
import helpers.*;
import interfaces.IController.Verb;

public class WelcomeView extends AbstractView {
	public final static String TITLE = "Nos amis les chiens";
	
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	public static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	public static final String LABEL_ADD_DOG = "Inscrire un chien...";
	public static final String ACTION_ADD_DOG = "Add Dog";
	public static final String LABEL_NAME = "name";
	public static final String LABEL_BREED = "breed";
	
	public WelcomeView() {
		super();
		
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(new WelcomePanel(), BorderLayout.CENTER);
		this.add(new ActionPanel(), BorderLayout.SOUTH);
		
		this.display();
	}
	
	// Region sub components
	/**
	 * Sub-component WelcomePanel
	 */
	private class WelcomePanel extends JPanel {
		public WelcomePanel() {
			super();
			this.setLayout(new BorderLayout());
			this.add(new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER), BorderLayout.NORTH);
			this.add(new JExtImage(this, WELCOME_PICTURE), BorderLayout.CENTER);
		}
	}
	
	/**
	 * Sub-component ActionPanel
	 */
	private class ActionPanel extends JPanel {
		public ActionPanel() {
			super();
			this.add(new JExtRouteInvokerButton(LABEL_ADD_DOG, DogController.class, Verb.Create));
		}
	}
}
