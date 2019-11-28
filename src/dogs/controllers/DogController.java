package dogs.controllers;

import java.util.Collection;

import abstracts.Controller;
import abstracts.RepositoryManager;
import dogs.models.Dog;
import dogs.views.Dogs.DogCreateView;
import dogs.views.Dogs.DogIndexView;
import interfaces.IRepository;

public class DogController extends Controller<Dog> {

	@SuppressWarnings("unchecked")
	private IRepository<Dog> dogRepository = (IRepository<Dog>) RepositoryManager.getModelRepository(Dog.class);
	
	/**
	 * @since Exercice 4, step 7
	 */
	@Override
	protected void index(Object arguments) {
		Collection<Dog> dogList = this.dogRepository.select();
		new DogIndexView(dogList);
	}
	
	/**
	 * @since Exercice 4, step 3
	 */
	@Override
	protected void create(Object arguments) { new DogCreateView(); }
	
	/**
	 * @since Exercice 4, step 5
	 */
	@Override
	protected void store(Object arguments) {
		Dog dog = (Dog) arguments;
		dog.persist();
	}
}
