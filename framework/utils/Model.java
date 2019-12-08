package utils;

import interfaces.IModel;
import interfaces.IRepository;

public abstract class Model implements IModel {
	private static final long serialVersionUID = 1L;
	private int id = IRepository.NULL_ID;
	
	@Override
	public final int getId() {
		return this.id;
	};
	
	@Override
	public final void setId(int id) {
		this.id = id;
	}
}
