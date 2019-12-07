package dogs.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingUtilities;

import abstracts.AbstractView;
import abstracts.Controller.Verb;
import dogs.controllers.DogController;
import dogs.models.Client;
import dogs.views.Clients.ClientCreateView;
import helpers.*;

public class WelcomeView extends AbstractView {
	public final static String TITLE = "Nos amis les chiens";
	
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	public static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	public static final String LABEL_ADD_DOG = "Inscrire un chien...";
	public static final String LABEL_CLIENT = "Clients";
	public static final String ACTION_ADD_DOG = "Add Dog";
	public static final String LABEL_NAME = "name";
	public static final String LABEL_BREED = "breed";
	
	public static final String TAB_LABEL_WELCOME = "Acceuille";
	public static final String TAB_LABEL_CLIENT = "Gestions des clients";
	
	private Collection<Client> clients;
	
	public WelcomeView(final Collection<Client> clients) {
		super(TITLE);
		
		this.clients = clients;
		
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPanel = new JTabbedPane();
		final Dimension originalTabsDim = tabbedPanel.getPreferredSize();
		final JFrame thisRef = this;
		tabbedPanel.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Component currentPanel = ((JTabbedPane) e.getSource()).getSelectedComponent();
				Dimension panelDim = currentPanel.getPreferredSize();

                Dimension nd = new Dimension(
                        originalTabsDim.width + panelDim.width,
                        originalTabsDim.height + panelDim.height);

                tabbedPanel.setPreferredSize(nd);

                thisRef.pack();
			}
		});
		
		tabbedPanel.addTab(TAB_LABEL_WELCOME, new WelcomeTabPanel());
		tabbedPanel.addTab(TAB_LABEL_CLIENT, new ClientTabPanel());
		this.add(tabbedPanel);
		
		
		this.display();
	}
	
	// Region sub components
	
	private class ClientTabPanel extends JPanel {
		public ClientTabPanel() {
			this.setLayout(new BorderLayout());
			this.add(new ClientCreateView());
			this.add(new ClientView(clients));
		}
	}
	
	private class WelcomeTabPanel extends JPanel {
		
		public WelcomeTabPanel() {
			this.setLayout(new BorderLayout());
			this.add(new WelcomeSplashPanel(), BorderLayout.CENTER);
			this.add(new ActionPanel(), BorderLayout.SOUTH);
		}
		
		/**
		 * Sub-component WelcomePanel
		 */
		private class WelcomeSplashPanel extends JPanel {
			public WelcomeSplashPanel() {
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
				this.add(new JExtRouteInvokerButton(LABEL_ADD_DOG, DogController.class, Verb.Index));
			}
		}
	}
}
