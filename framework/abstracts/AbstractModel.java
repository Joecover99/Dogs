package abstracts;

import interfaces.IModel;
import interfaces.IRepository;

public abstract class AbstractModel implements IModel {
	private int _id = IRepository.NULL_ID;
	
	@Override
	public final int getId() {
		return this._id;
	};
	
	@Override
	public final void setId(int id) {
		this._id = id;
	}
}
