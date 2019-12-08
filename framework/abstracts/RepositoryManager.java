package abstracts;

import java.util.HashMap;

import interfaces.IRepository;

public class RepositoryManager {
	
	private RepositoryManager() { }
	
	private static HashMap<Class<?>, IRepository<?>> repositories = new HashMap<Class<?>, IRepository<?>>();
	
	public static IRepository<?> getModelRepository(Class<?> modelClass) {
		return RepositoryManager.getOrCreateRepositoryInstance(modelClass);
	}
	
	private static IRepository<?> getOrCreateRepositoryInstance(Class<?> modelClass) {
		if(repositories.containsKey(modelClass)) {
			return repositories.get(modelClass);
		}
		
		IRepository<?> newRepository = null;
		try {
			newRepository = (IRepository<?>) modelClass.newInstance();
			repositories.put(modelClass, newRepository);
		} catch (InstantiationException | IllegalAccessException e) {
			// Won't throw. TODO
		}
		
		return newRepository;
	}
	
	public static void bootstrap(HashMap<Class<?>, IRepository<?>> ModelForRepositoryMapping) {
		RepositoryManager.repositories = ModelForRepositoryMapping;
	}
}
