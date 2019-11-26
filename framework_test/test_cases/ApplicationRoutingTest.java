package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import abstracts.Controller.Verb;
import exceptions.InadequateControllerConstructorException;
import helpers.ApplicationRouting;

class ApplicationRoutingTest {

	class NonNullaryController {
		public NonNullaryController(int parameter) { }
	}
	
	@Test
	void invoke_IF_controller_has_non_nullary_constructor_THROW_InadequateControllerConstructorException() {
		// Act & assert
		assertThrows(InadequateControllerConstructorException.class, () -> {
			ApplicationRouting.invoke(NonNullaryController.class, Verb.Create);
		});
	}
	
	@Test
	void invoke_CALL_() {
		// Act & assert
		assertThrows(InadequateControllerConstructorException.class, () -> {
			ApplicationRouting.invoke(NonNullaryController.class, Verb.Create);
		});
	}

}
