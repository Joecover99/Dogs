package dogs.repositories;

import java.util.Collection;
import abstracts.AbstractRepository;
import dogs.models.Dog;

public class DogMemoryRepository extends AbstractRepository<Dog> implements IDogRepository {

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
/*
public abstract class Entity

	private int id
	
	public Entity() {}

public int getId() {
	return this.id;
}

public void setId(int id) {
	this.id = id;
}*/