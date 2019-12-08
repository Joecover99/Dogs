package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.Test;

import components.JExtButton;

class JExtButtonTest {
	
	private static final String ANY_TITLE = "TEST";

	@Test
	void button_execute_given_task_on_click() {
		// Arrange
		JExtButton button = new JExtButton(ANY_TITLE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				assertTrue(true);
			}
		});
		
		// Act
		button.doClick();
	}
	
	@Test
	void button_have_given_title() {
		// Arrange
		JExtButton button = new JExtButton(ANY_TITLE, null);
		
		// Assert
		assertEquals(ANY_TITLE, button.getText());
	}
}
