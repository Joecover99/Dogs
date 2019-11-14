package dogs.model;

import java.util.Collection;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import dogs.view.DogCreateView;
import dogs.view.IView;

public class DogMemoryRepository implements IDogRepository {

	private Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();

	@Override
	public void add(Dog newDog) {
		// TODO Auto-generated method stub
		dogs.put(newDog.getId(), newDog);
	}

	@Override
	public Collection<Dog> getList() {
		// TODO Auto-generated method stub
		return this.dogs.values();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.dogs.size();
	}

	@Override
	public Dog SearchById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Dog> SearchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*private void add(Dog newDog) {
		this.newDog = newDog;
	}*/
}
