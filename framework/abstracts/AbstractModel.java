package abstracts;


import interfaces.IModel;
import interfaces.IRepository;

public abstract class AbstractModel implements IModel {
	
	private IRepository<IModel> repository;
	private int id = IRepository.NULL_ID;
	
	@SuppressWarnings("unchecked")
	public AbstractModel() {
		this.repository = (IRepository<IModel>) RepositoryManager.getModelRepository(this.getClass());
	}
	
	@Override
	public final int getId() {
		return this.id;
	};
	
	@Override
	public final void setId(int id) {
		this.id = id;
	}
	
	@Override
	public final void persist() {
		this.repository.insert(this);
	}
	
	@Override
	public void save() {
		this.repository.update(this);
	}
}
