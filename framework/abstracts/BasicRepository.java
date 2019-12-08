package abstracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.IModel;
import interfaces.IRepository;

/**
 * A basic repository with methods to insert, delete, update and select with or without filter and sorter.
 * Can be extended to implement more specific methods.
 * @author Benjamin Bergeron
 *
 * @param <T> The model class held within the repository
 */
public class BasicRepository<T extends IModel> implements IRepository<T> {
	
	/**
	 * Keep the next available ID for insertion
	 */
	private Integer nextId = IRepository.STARTING_ID;
	
	/**
	 * A hash map linking each instance to it's ID
	 */
	protected HashMap<Integer, T> rows = new HashMap<Integer, T>();
	
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
	public void update(T item) {
		if(item.getId() == NULL_ID) {
			this.insert(item);
		} else {
			this.rows.replace(item.getId(), item);
		}
	};
	
	@Override
	public void delete(T item) {
		this.rows.remove(item.getId());
		item.setId(NULL_ID);
	};
}
