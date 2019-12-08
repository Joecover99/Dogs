package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import components.View;

class ViewTest {
	
	private static final String ANY_TITLE = "Title";
	
	private View view = null;
	
	@SuppressWarnings("serial")
	@BeforeEach
	private void init() {
		this.view = new View(ANY_TITLE) { };
	}
	
	@AfterEach
	private void dispose() {
		this.view.dispose();
	}

	@Test
	void view_has_given_title() {
		assertEquals(ANY_TITLE, view.getTitle());
	}
	
	@Test
	void view_are_not_resizable() {
		assertFalse(view.isResizable());
	}
	
	@Test
	void display_set_view_visible() {
		// Act
		view.display();
		
		// Assert
		assertTrue(view.isVisible());
	}
	
	@Test
	void display_pack_view() {
		// Act
		view.display();
		
		// Assert
		Dimension dimension1 = view.getSize();
		view.pack();
		Dimension dimension2 = view.getSize();
		assertEquals(dimension1, dimension2);
	}

}
