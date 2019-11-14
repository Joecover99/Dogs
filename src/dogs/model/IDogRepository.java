package dogs.model;

public interface IDogRepository {

	void add(Dog newDog);
	
	Collection<Dog> getList();
	
	int size();
	
	Dog SearchById(int id);
	
	Collection<Dog> SearchByName(String name);
}
