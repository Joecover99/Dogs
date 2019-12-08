package interfaces;

import java.util.List;

import exceptions.ModelNotPersistedException;

public interface IRepository<T extends IModel> {
	// Constexpr
	public static final int NULL_ID = -1;
	public static final int STARTING_ID = 0;
	
	// Methods signatures
	/**
	 * Persist a copy of the given model and add the id to the instance
	 * @param item The model instance to persist
	 */
	void insert(T item);
	void update(final T item) throws ModelNotPersistedException;
	void delete(T item) throws ModelNotPersistedException;
	
	T select(final int id) throws ModelNotPersistedException;
	List<T> selectAll();
}
