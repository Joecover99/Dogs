package abstracts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import interfaces.IModel;
import interfaces.IRepository;

/**
 * Can be extanded to add more specific method
 * @param <T>
 */
public class BasicRepository<T extends IModel> implements IRepository<T> {
	
	/**
	 * Keep the next available ID for insertion
	 */
	private Integer nextId;
	
	/**
	 * A hash map linking each instance to it's ID
	 */
	protected HashMap<Integer, T> rows = new HashMap<Integer, T>();
	
	// CONSTRUCTORS
	public BasicRepository() {
		this.nextId = STARTING_ID;
	}
	
	// MISC
	
	public void insert(T item) {
		item.setId(nextId);
		this.rows.put(nextId ++, item);
	};
	
	// Selects
	@Override
	public T select(int id) {
		return this.rows.get(id);
	};
	@Override
	public List<T> select() {
		return new ArrayList<T>(this.rows.values());
	}
	@Override
	public List<T> select(Predicate<T> filter) {
		List<T> list = this.select();
		list.removeIf(e -> filter.test(e));
		return list;
	}
	@Override
	public List<T> select(Comparator<T> sortComparator) {
		List<T> list = this.select();
		list.sort(sortComparator);
		return list;
	}
	@Override
	public List<T> select(Predicate<T> filter, Comparator<T> sortComparator) {
		List<T> list = this.select(filter);
		list.sort(sortComparator);
		return list;
	}
	
	@Override
	public void update(T item) {
		if(item.getId() == NULL_ID) {
			this.insert(item);
		} else {
			this.rows.replace(item.getId(), item);
		}
	};
	
	@Override
	public void delete(T item) {
		item.setId(NULL_ID);
		this.rows.remove(item.getId());
	};
}
