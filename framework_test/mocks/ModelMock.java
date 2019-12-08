package mocks;

import abstracts.RepositoryManager;
import interfaces.IModel;
import interfaces.IRepository;

public class ModelMock implements IModel {

	private IRepository<IModel> repository;
	public int id = IRepository.NULL_ID;
	
	@SuppressWarnings("unchecked")
	public void AbstractModel() {
		this.repository = (IRepository<IModel>) RepositoryManager.getModelRepository(this.getClass());
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void persist() {
		// TODO Auto-generated method stub
		this.repository.insert(this);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		this.repository.update(this);
	}

}
