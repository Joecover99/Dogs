package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import mocks.FormMock;

class FormTest {
	
	private Object[][] ANY_LABEL_FIELD_LIST = new Object[][] {
		{"1", new JTextArea()},
		{"1", new JTextArea()},
		{"1", new JTextArea()}
	};
	
	@Test
	void form_create_JExtLabeledComponent_foreach_in_provided_list() {
		FormMock form = new FormMock(ANY_LABEL_FIELD_LIST);
		assertEquals(ANY_LABEL_FIELD_LIST.length, form.getComponentCount() - 1);
	}
	
	@Test
	void when_submit_button_clicked_and_valid_submit() {
		// Arrange
		FormMock form = new FormMock(ANY_LABEL_FIELD_LIST);
		JButton button = (JButton) form.getComponent(form.getComponentCount() - 1);
		
		// Act
		button.doClick();
		
		// Assert
		assertTrue(form.wasSubmited);
	}
	
	@Ignore("Open an anoying popup - disabled for group test") // @Test
	void when_submit_button_clicked_and_not_valid_open_dont_submit() {
		// Arrange
		FormMock form = new FormMock(ANY_LABEL_FIELD_LIST);
		JButton button = (JButton) form.getComponent(form.getComponentCount() - 1);
		form.isValid = false;
		
		// Act
		button.doClick();
		
		// Assert
		assertFalse(form.wasSubmited);
	}

}
