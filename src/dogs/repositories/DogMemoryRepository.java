package dogs.repositories;

import java.util.Collection;
import abstracts.BasicRepository;
import dogs.models.Dog;

public class DogMemoryRepository extends BasicRepository<Dog> implements IDogRepository {

	@Override
	public Collection<Dog> selectByOwnerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Dog> selectByRace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Dog> selectOrderedByDogName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
