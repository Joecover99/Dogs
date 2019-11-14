package dogs;

import dogs.model.Dog;
import dogs.model.IDogRepository;

public class DogDataSeeder {

	private IDogRepository repository;
	
	public DogDataSeeder(IDogRepository repository) {
		this.repository = repository;
		this.seedTable();
	}
	
	private void seedTable() {
		this.repository.add(new Dog("bobby", "Batard"));
		this.repository.add(new Dog("Niko", "Batard"));
		this.repository.add(new Dog("Santa", "Batard"));
		this.repository.add(new Dog("Joecover", "Batard"));
	}
}
