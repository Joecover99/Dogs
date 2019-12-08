package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import components.JExtLabeledComponent;

class JExtLabeledComponentTest {
	
	private static final String ANY_TITLE = "Title";
	private static final Component ANY_COMPONENT = new JTextField();
	
	private JExtLabeledComponent labeledComponent = null;
	
	@BeforeEach
	private void init() {
		labeledComponent = new JExtLabeledComponent(ANY_TITLE, ANY_COMPONENT);
	}

	@Test
	void the_first_component_is_a_label_with_given_title() {
		// Assert
		String returnedTitle = ((JLabel) labeledComponent.getComponent(0)).getText();
		assertEquals(ANY_TITLE, returnedTitle);
	}
	
	@Test
	void the_second_component_is_the_provided_component() {
		// Assert
		assertEquals(ANY_COMPONENT, labeledComponent.getComponent(1));
	}

}
