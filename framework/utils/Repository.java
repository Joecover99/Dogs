package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.ModelNotPersistedException;
import interfaces.IModel;
import interfaces.IRepository;

/**
 * A basic repository with methods to insert, delete, update and select with or without filter and sorter.
 * Can be extended to implement more specific methods.
 * @author Benjamin Bergeron
 *
 * @param <T> The model class held within the repository
 */
public class Repository<T extends IModel> implements IRepository<T> {
	
	/**
	 * Keep the next available ID for insertion
	 */
	private Integer nextId = IRepository.STARTING_ID;
	
	/**
	 * A hash map linking each instance to it's ID
	 */
	protected HashMap<Integer, T> rows = new HashMap<Integer, T>();
	
	@Override
	public void insert(T item) {
		item.setId(nextId);
		this.rows.put(nextId ++, this.getSafeCopy(item));
	};
	
	@Override
	public T select(int id) throws ModelNotPersistedException {
		T instance = this.rows.get(id);
		
		if(instance == null) {
			throw new ModelNotPersistedException();
		}
		
		return this.getSafeCopy(instance);
	};
	
	@Override
	public List<T> selectAll() {
		List<T> all = new ArrayList<T>(this.rows.values());
		
		for (int i = 0; i < all.size(); i++) {
			T model = all.get(i);
			this.getSafeCopy(model);
			all.set(i, model);
		}
		
		return all;
	}
	
	@Override
	public void update(final T item) throws ModelNotPersistedException {
		if(item.getId() == NULL_ID) {
			throw new ModelNotPersistedException();
		}
		
		T copy = this.getSafeCopy(item);
		this.rows.replace(item.getId(), copy);
	};
	
	@Override
	public void delete(T item) throws ModelNotPersistedException {
		if(item.getId() == NULL_ID || !this.rows.containsKey(item.getId())) {
			throw new ModelNotPersistedException();
		}
		
		this.rows.remove(item.getId());
		item.setId(NULL_ID);
	};
	
	/**
	 * Make an identical copy of a given instance using serialization
	 * @param model
	 * @return A copy of the given instance
	 */
	@SuppressWarnings("unchecked")
	private T getSafeCopy(T model) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(model);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bis);
			return (T) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return null; // Will never happen
		}
	}
}
