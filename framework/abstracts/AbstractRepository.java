package abstracts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import interfaces.IModel;
import interfaces.IRepository;

public abstract class AbstractRepository<T extends IModel> implements IRepository<T> {
	private Integer nextId;
	protected HashMap<Integer, T> rows = new HashMap<Integer, T>();
	
	public AbstractRepository() {
		this.nextId = STARTING_ID;
	}
	
	public void insert(T item) {
		item.setId(nextId);
		this.rows.put(nextId ++, item);
	};
	
	@Override
	public T select(int id) {
		return this.rows.get(id);
	};
	
	@Override
	public Collection<T> selectMany(Predicate<T> filter) {
		return this.rows
				.values()
				.stream()
				.filter(filter)
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<T> selectAll() {
		return new ArrayList<T>(this.rows.values());
	}
	
	@Override
	public void update(int index, T item) {
		item.setId(index);
		this.rows.replace(index, item);
	};
	
	@Override
	public void delete(T item) {
		item.setId(NULL_ID);
		this.rows.remove(item.getId());
	};
	
	@Override
	public int getSize() {
		return this.nextId;
	};
}
