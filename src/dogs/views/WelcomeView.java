package dogs.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import components.*;
import dogs.controllers.ClientController;
import dogs.controllers.DogController;

@SuppressWarnings("serial")
public class WelcomeView extends View {
	public final static String TITLE = "Nos amis les chiens";
	
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	public static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	public static final String LABEL_ADD_DOG = "Inscrire un chien...";
	public static final String LABEL_CLIENT = "Clients";
	public static final String ACTION_ADD_DOG = "Add Dog";
	public static final String LABEL_NAME = "name";
	public static final String LABEL_BREED = "breed";
	
	public static final String LABEL_CLIENT_MANAGEMENT = "Gestions des clients";
	public static final String LABEL_DOG_MANAGEMENT = "Gestions des chiens";
	
	public WelcomeView() {
		super(TITLE);
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.add(new WelcomeSplashPanel(), BorderLayout.CENTER);
		this.add(new ActionPanel(), BorderLayout.SOUTH);
		
		this.display();
	}
	
	/**
	 * Sub-component WelcomePanel
	 */
	private class WelcomeSplashPanel extends JPanel {
		public WelcomeSplashPanel() {
			super();
			this.setLayout(new BorderLayout());
			this.add(new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER), BorderLayout.NORTH);
			this.add(new JLabel(new ImageIcon(this.getClass().getResource(WELCOME_PICTURE))), BorderLayout.CENTER);
		}
	}
	
	/**
	 * Sub-component ActionPanel
	 */
	private class ActionPanel extends JPanel {
		public ActionPanel() {
			super();
			
			this.add(new JExtButton(LABEL_DOG_MANAGEMENT, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { DogController.index(); }
			}));
			
			this.add(new JExtButton(LABEL_CLIENT_MANAGEMENT, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { ClientController.index(); }
			}));
		}
	}
}
