package dogs.controllers;

import java.util.List;

import abstracts.RepositoryManager;
import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import dogs.views.Dogs.DogEditView;
import dogs.views.Dogs.DogIndexView;
import interfaces.IRepository;

public class DogController {

	@SuppressWarnings("unchecked")
	private static IRepository<Dog> dogRepository = (IRepository<Dog>) RepositoryManager.getModelRepository(Dog.class);
	@SuppressWarnings("unchecked")
	private static IRepository<Dog> clientRepository = (IRepository<Dog>) RepositoryManager.getModelRepository(Client.class);
	
	public static void index() {
		List<Dog> dogList = dogRepository.select();
		Client[] clients = clientRepository.select().toArray(new Client[0]);
		new DogIndexView(dogList, clients);
	}
	
	public static void delete(Dog dog) {
		dogRepository.delete(dog);
	}

	public static void store(String name, Breed breed, Client owner) {
		new Dog(name, breed, owner).persist();
	}

	public static void update(final int id, final String name, final Breed breed) {
		Dog dog = dogRepository.select(id);
		dog.setName(name);
		dog.setBreed(breed);
		dog.save();
	}
	
	public static void edit(final int id) {
		Dog dog = dogRepository.select(id);
		new DogEditView(dog);
	}
}
