package helpers;

import java.util.HashMap;

import abstracts.Controller;
import abstracts.Controller.Verb;
import exceptions.InadequateControllerConstructorException;
import interfaces.IModel;

public final class ApplicationRouting {
	
	private ApplicationRouting() { }
	
	@SuppressWarnings("rawtypes")
	private static final HashMap<Class<?>, Controller> controllers = new HashMap<Class<?>, Controller>();
	
	public static void invoke(Class<?> controllerClass, Verb verb) throws InadequateControllerConstructorException {
		invoke(controllerClass, verb, null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void invoke(Class<?> controllerClass, Verb verb, IModel param) throws InadequateControllerConstructorException {
		Controller instance = getOrInstantiate(controllerClass);
		instance.invokeRoute(verb, param);
	}
	
	@SuppressWarnings("rawtypes")
	private static Controller getOrInstantiate(Class<?> controllerClass) throws InadequateControllerConstructorException {
		if(controllers.containsKey(controllerClass)) {
			return controllers.get(controllerClass);
		} else {
			Controller controller;
			try {
				controller = (Controller) controllerClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new InadequateControllerConstructorException(e);
			}
			controllers.put(controllerClass, controller);
			
			return controller;
		}
	}
}
