package test_cases;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

import abstracts.Controller;
import abstracts.Controller.Verb;
import exceptions.NullRouteVerbException;
import exceptions.UnimplementedRouteException;
import mocks.ModelMock;
import mocks.SpyController;

class ControllerTest {
	
	@ParameterizedTest
	@EnumSource(value = Verb.class) // This will execute the test with each member of verb
	void default_Controller_invokeRoute_THROWS_UnimplementedRouteException_FOREACH_verb(Verb verb) {
		// Arrange
		@SuppressWarnings("rawtypes")
		Controller controller = new Controller() { };
		
		// Assert
		assertThrows(UnimplementedRouteException.class, () -> {
			controller.invokeRoute(verb);
		});
	}
	
	@ParameterizedTest
	@EnumSource(value = Verb.class)
	void invokeRoute_CALL_corresponding_protected_method(Verb verb) {
		// Arrange
		SpyController controller = new SpyController();
		
		// Act
		controller.invokeRoute(verb);
		
		// Assert
		assertEquals(verb, controller.usedVerb);
	}
	
	@Test
	void invokeRoute_null_THROWS_IllegalRouteException() {
		// Arrange
		@SuppressWarnings("rawtypes")
		Controller controller = new Controller() {};
		
		// Assert
		assertThrows(NullRouteVerbException.class, () -> {
			controller.invokeRoute(null);
		});
	}
	
	@SuppressWarnings("unchecked")
	@ParameterizedTest
	@EnumSource(value = Verb.class, names = { "Store", "Show", "Edit", "Update", "Destroy" }, mode = Mode.INCLUDE)
	void invokeRoute_CALL_corresponding_method_WITH_given_argument(Verb verb) {
		// Arrange
		SpyController controller = new SpyController();
		ModelMock argument = new ModelMock();
		
		// Act
		controller.invokeRoute(verb, argument);
		
		// Assert
		assertSame(argument, controller.usedArgument);
	}
	
}
