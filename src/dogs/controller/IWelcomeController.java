package dogs.controller;

import dogDTO.DogDTOForCreate;

public interface IWelcomeController {

	void startApplication();

	void wantToCreateDog();

	void add(DogDTOForCreate dogToCreate);
	
}
