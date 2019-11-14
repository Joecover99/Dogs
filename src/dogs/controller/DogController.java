package dogs.controller;

import java.util.ArrayList;
import java.util.Collection;

import dogDTO.DogDTO;
import dogDTO.DogDTOForCreate;
import dogDTO.DogDTOForList;
import dogs.model.Dog;
import dogs.model.IDogRepository;
import dogs.view.DogCreateView;
import dogs.view.DogListView2;
import dogs.view.IDogController;
import dogs.view.IView;

public class DogController implements IDogController {

	IDogRepository repository;

	public DogController(IDogRepository dogRepository) {
		this.repository = dogRepository;
	}
	
	public void goToCreate() {
		IView dogCreateView = new DogCreateView(this);
		dogCreateView.display();
	}
	
	public void add(DogDTOForCreate dogToCreate) {
			Dog newDog = new Dog(dogToCreate.name, dogToCreate.breed);
			this.repository.add(newDog);
	}
	
	public void goToList() {
		Collection<DogDTOForList> dogDTOList = new ArrayList<DogDTOForList>();
		for(Dog dog:this.repository.getList()) {
			DogDTOForList dogDTO = new DogDTOForList(dog.getId(),dog.getName(), dog.getBreed());
			dogDTOList.add(dogDTO);
		}
		IView listOfDogsView = new DogListView2(this, dogDTOList);
		listOfDogsView.display();
	}
}
