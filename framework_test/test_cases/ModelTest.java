package test_cases;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import abstracts.AbstractModel;
import abstracts.Controller;
import abstracts.Controller.Verb;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import exceptions.UnimplementedRouteException;
import mocks.ModelMock;

class ModelTest {
	void default_Controller_invokeRoute_THROWS_UnimplementedRouteException_FOREACH_verb() {
		// Arrange
		@SuppressWarnings("rawtypes")
		Dog dog = new Dog(null, null) { };
		
		// Assert
		assertThrows(UnimplementedRouteException.class, () -> {
			dog.getBreed();
		});
	}
	
	
}
