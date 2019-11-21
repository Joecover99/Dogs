package dogs.controllers;

import java.util.Collection;

import dogs.models.Dog;
import dogs.models.IDogRepository;
import dogs.views.Dogs.DogCreateView;
import dogs.views.Dogs.DogIndexView;
import interfaces.IController;
import interfaces.IRepository;

public class DogController implements IController<Dog> {

	private IDogRepository repository;
	
	public void setRepository(IDogRepository repository) {
		this.repository = repository;
	}

	/**
	 * @since Exercice 4, step 7
	 */
	@Override
	public void index() {
		Collection<Dog> dogList = this.repository.selectAll();
		new DogIndexView(dogList);
	}
	
	/**
	 * @since Exercice 4, step 3
	 */
	@Override
	public void create() { new DogCreateView(); }
	
	/**
	 * @since Exercice 4, step 5
	 */
	@Override
	public void store(Dog item) {
		System.out.print("YEET");
	}
}
