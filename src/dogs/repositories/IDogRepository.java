package dogs.repositories;

import java.util.Collection;

import dogs.models.Dog;
import interfaces.IRepository;

public interface IDogRepository extends IRepository<Dog> {
	Collection<Dog> selectByOwnerName();
	Collection<Dog> selectByRace();
	Collection<Dog> selectOrderedByDogName();
}
