package interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T extends IModel> {
	public static final int NULL_ID = -1;
	public static final int STARTING_ID = 0;
	
	void insert(T item);
	void update(T item);
	void delete(T item);
	
	T select(int id);
	List<T> select();
	List<T> select(Predicate<T> filter);
	List<T> select(Predicate<T> filter, Comparator<T> sortComparator);
	List<T> select(Comparator<T> sortComparator);
}
