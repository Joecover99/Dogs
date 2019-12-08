package mocks;

import java.util.Random;

import interfaces.IModel;
import interfaces.IRepository;

@SuppressWarnings("serial")
public class ModelMock implements IModel {
	
	public int uniqueId = new Random().nextInt();
	
	public int id = IRepository.NULL_ID;
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((ModelMock) obj).uniqueId == this.uniqueId;
	}
}
