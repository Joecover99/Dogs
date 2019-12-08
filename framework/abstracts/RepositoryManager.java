package abstracts;

import java.util.HashMap;

import interfaces.IModel;
import interfaces.IRepository;

public class RepositoryManager {
	
	private RepositoryManager() { }
	
	private static HashMap<Class<? extends IModel>, IRepository<? extends IModel>> repositories = new HashMap<Class<? extends IModel>, IRepository<? extends IModel>>();
	
	public static <M extends IModel> IRepository<? extends IModel> getModelRepository(Class<? extends IModel> modelClass) {
		if(repositories.containsKey(modelClass)) {
			return repositories.get(modelClass);
		}
		
		IRepository<?> newRepository = new BasicRepository<M>();
		repositories.put(modelClass, newRepository);
		
		return newRepository;
	}
}
