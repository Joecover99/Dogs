package dogs.seeders;

import dogs.factories.DogFactory;
import dogs.models.IDogRepository;

public class DogDataSeeder {

	private IDogRepository repository;
	
	public DogDataSeeder(IDogRepository repository) {
		this.repository = repository;
		this.seedTable();
	}
	
	private void seedTable() {
		DogFactory factory = new DogFactory();
		this.repository.insert(factory.generate());
	}
}
