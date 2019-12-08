package helpers;

import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Like a JTabbedPane, but auto-resize to fit the selected panel
 * @author Benjamin Bergeron
 */
public class JExtDynamicTabbedPanel extends JTabbedPane {
	
	public JExtDynamicTabbedPanel() {
		final Dimension originalTabsDim = this.getPreferredSize();
		
		JTabbedPane thisTabbedPanel = this;
		this.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Dimension currentPanelDim = thisTabbedPanel
						.getSelectedComponent()
						.getPreferredSize();

                Dimension nd = new Dimension(
                        originalTabsDim.width + currentPanelDim.width,
                        originalTabsDim.height + currentPanelDim.height);

                thisTabbedPanel.setPreferredSize(nd);
                SwingUtilities.getWindowAncestor(thisTabbedPanel).pack();
			}
		});
	}
}
