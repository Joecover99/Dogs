package dogs.model;

import java.util.Collection;

public interface IDogRepository {

	void add(Dog newDog);
	
	Collection<Dog> getList();
	
	int size();
	
	Dog SearchById(int id);
	
	Collection<Dog> SearchByName(String name);
}
