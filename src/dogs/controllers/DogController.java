package dogs.controllers;

import java.util.Collection;

import abstracts.Controller;
import dogs.models.Dog;
import dogs.repositories.IDogRepository;
import dogs.views.Dogs.DogCreateView;
import dogs.views.Dogs.DogIndexView;
import interfaces.IRepository;

public class DogController extends Controller<Dog> {

	private IDogRepository repository;
	
	public void setRepository(IDogRepository repository) {
		this.repository = repository;
	}

	/**
	 * @since Exercice 4, step 7
	 */
	@Override
	protected void index() {
		Collection<Dog> dogList = this.repository.selectAll();
		new DogIndexView(dogList);
	}
	
	/**
	 * @since Exercice 4, step 3
	 */
	@Override
	protected void create() { new DogCreateView(); }
	
	/**
	 * @since Exercice 4, step 5
	 */
	@Override
	protected void store(Dog item) {
		System.out.print("YEET");
	}
}
