package interfaces;

import java.util.Collection;
import java.util.function.Predicate;

public interface IRepository<T extends IModel> {
	public static final int NULL_ID = -1;
	public static final int STARTING_ID = 0;
	
	void insert(T item);
	T select(int id);
	void update(int index, T item);
	void delete(T item);
	
	Collection<T> selectMany(Predicate<T> filter);
	Collection<T> selectAll();
	
	int getSize();
	
	
	// void save();
}
