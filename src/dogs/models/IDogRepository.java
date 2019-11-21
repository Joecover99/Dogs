package dogs.models;

import java.util.Collection;

import interfaces.IRepository;

public interface IDogRepository extends IRepository<Dog> {
	Collection<Dog> selectByOwnerName();
	Collection<Dog> selectByRace();
	Collection<Dog> selectOrderedByDogName();
}
