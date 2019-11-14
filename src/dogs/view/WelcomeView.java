package dogs.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dogDTO.DogDTO;
import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends JFrame implements IView, ActionListener {   // Configurer Eclipse pour ignorer les avertissements sur serial Id
	
	private static final String VIEW_TITLE = "Nos amis les chiens";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final String ADD_DOG_MESSAGE = "Insert a Dog";
	private static final String ACTION_ADD_DOG = "Add Dog";
	private static final String LABEL_NAME = "name";
	private static final String LABEL_BREED = "breed";
	
	
	private IWelcomeController controller;		// Pas encore utilisé dans cette version...
	
	public WelcomeView(IWelcomeController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		// setSize(): uniquement car JFrame avec une image - Ne pas utiliser avec les gestionnaires de mise en forme-Utiliser la méthode pack() à la place
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// par défaut: HIDE_ON_CLOSE
	}
	
	private void setUpComponents() {
		//this.setLayout(new BorderLayout());  					// Inutile car par défaut...
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  // CENTER -> par défaut

		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme		
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);	
		addDogButton(welcomePanel, ADD_DOG_MESSAGE, ACTION_ADD_DOG);
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(this, WELCOME_PICTURE);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);   // CENTER -> par défaut
	}
	
	private void addTextField(JPanel panel, String labelText, JTextField textField) {
		panel.add(new JLabel(labelText));
		panel.add(textField);
	}
	
	private void setUpInputDataPanel() {
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(0,2));
		
		this.addTextField(inputDataPanel, LABEL_NAME ,this.name);
		this.addTextField(inputDataPanel, LABEL_BREED ,this.breed);
	}
	
	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		addDogButton(actionPanel, ADD_DOG_MESSAGE, ACTION_ADD_DOG);
	}
	
	private void addDogButton(JPanel actionPanel, String buttonText, String buttonAction){
		JButton addDogButton = new JButton(buttonText);
		addDogButton.setActionCommand(buttonAction);
		addDogButton.addActionListener(this);
		actionPanel.add(addDogButton);
	}
	
	private void actionAddDogAsked() {
		this.controller.wantToCreateDog();
	}
	
	private void createDog() {
		System.out.println("ICI");
		DogDTO dogCreate = new DogDTO(this.name, this.breed);
		this.controller.add(dogToCreate);
		JOptionPane.showMessageDialog(this.THAT);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ACTION_ADD_DOG)) {
			this.actionAddDogAsked();
		}
	}
	


}
