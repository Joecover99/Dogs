package dogs.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import components.JExtButton;
import interfaces.IRepository;

@SuppressWarnings("serial")
public abstract class SearchModelInstanceByIdPanel extends JPanel {
	public final static String CONFIRM_BUTTON_LABEL = "Modifier";
	public final static int DEFAULT_INDEX = 0;
	
	public SearchModelInstanceByIdPanel(final String panelTitle, final int maxId) {
		this.setBorder(BorderFactory.createTitledBorder(panelTitle));
		
		JSpinner idInput = new JSpinner(new SpinnerNumberModel(DEFAULT_INDEX, IRepository.STARTING_ID, maxId, 1));
		this.add(idInput);
		
		JExtButton confirmButton = new JExtButton(CONFIRM_BUTTON_LABEL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = (int)idInput.getValue();
				onSelect(id);
			}
		});
		
		this.add(confirmButton);
	}
	
	protected abstract void onSelect(final int id);
}