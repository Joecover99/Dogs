package interfaces;

import java.util.List;

public interface IRepository<T extends IModel> {
	public static final int NULL_ID = -1;
	public static final int STARTING_ID = 0;
	
	void insert(T item);
	void update(T item);
	void delete(T item);
	
	T select(int id);
	List<T> select();
}
