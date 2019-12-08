package helpers;

import java.util.HashMap;

import abstracts.Controller;
import abstracts.Controller.Verb;
import dogs.controllers.ClientController;
import exceptions.InadequateControllerConstructorException;
import interfaces.IModel;

public final class ApplicationRouting {
	
	private ApplicationRouting() { }
	
	private static final HashMap<Class<?>, Controller<?>> controllers = new HashMap<Class<?>, Controller<?>>();
	
	@SuppressWarnings("unchecked")
	public static <T> T getController() {
		return (T) getOrInstantiate(T);
	}
	
	public static void invoke(Class<?> controllerClass, Verb verb) throws InadequateControllerConstructorException {
		invoke(controllerClass, verb, null);
	}
	
	public static void invoke(Class<?> controllerClass, Verb verb, Object param) throws InadequateControllerConstructorException {
		Controller<?> instance = getOrInstantiate(controllerClass);
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
				controllers.put(controllerClass, controller);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new InadequateControllerConstructorException(e);
			}
			
			return controller;
		}
	}
}
