package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.IRepository;
import utils.Model;

class ModelTest {
	
	private Model model = null;
	
	@SuppressWarnings("serial")
	@BeforeEach
	private void init() {
		this.model = new Model() { };
	}

	@Test
	void default_id_is_NULL_ID() {
		// Act
		int returnedId = model.getId();
		
		// Assert
		assertEquals(IRepository.NULL_ID, returnedId);
	}

	@Test
	void SetId_getID_correlation() {
		// Arrange
		final int ANY_ID = 5;
		
		// Act
		model.setId(ANY_ID);
		
		// Assert
		int returnedId = model.getId();
		assertEquals(ANY_ID, returnedId);
	}

}
