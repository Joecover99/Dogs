package dogs.controllers;

import java.util.List;

import dogs.MainAppDogs;
import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import dogs.views.Dogs.DogEditView;
import dogs.views.Dogs.DogIndexView;
import exceptions.ModelNotPersistedException;
import interfaces.IRepository;

public class DogController {

	private static IRepository<Dog> dogRepository = MainAppDogs.dogRepository;
	private static IRepository<Client> clientRepository = MainAppDogs.clientRepository;
	
	public static void index() {
		List<Dog> dogList = dogRepository.selectAll();
		Client[] clients = clientRepository.selectAll().toArray(new Client[0]);
		new DogIndexView(dogList, clients);
	}
	
	public static void delete(Dog dog) throws ModelNotPersistedException {
		dogRepository.delete(dog);
	}

	public static void store(String name, Breed breed, Client owner) {
		dogRepository.insert(new Dog(name, breed, owner));
	}

	public static void update(final int id, final String name, final Breed breed) throws ModelNotPersistedException {
		Dog dog = dogRepository.select(id);
		dog.setName(name);
		dog.setBreed(breed);
		dogRepository.update(dog);
	}
	
	public static void edit(final int id) throws ModelNotPersistedException {
		Dog dog = dogRepository.select(id);
		new DogEditView(dog);
	}
}
