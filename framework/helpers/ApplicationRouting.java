package helpers;

import java.util.HashMap;

import exceptions.InadequateControllerConstructorException;
import interfaces.IController;
import interfaces.IController.Verb;
import interfaces.IModel;

public final class ApplicationRouting {
	
	private ApplicationRouting() { }
	
	@SuppressWarnings("rawtypes")
	private static final HashMap<Class<?>, IController> controllers = new HashMap<Class<?>, IController>();
	
	public static void invoke(Class<?> controllerClass, Verb verb) throws InadequateControllerConstructorException {
		invoke(controllerClass, verb, null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void invoke(Class<?> controllerClass, Verb verb, IModel param) throws InadequateControllerConstructorException {
		IController instance = getOrInstantiate(controllerClass);
		instance.invokeRoute(verb, param);
	}
	
	@SuppressWarnings("rawtypes")
	private static IController getOrInstantiate(Class<?> controllerClass) throws InadequateControllerConstructorException {
		if(controllers.containsKey(controllerClass)) {
			return controllers.get(controllerClass);
		} else {
			IController controller;
			try {
				controller = (IController) controllerClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new InadequateControllerConstructorException(e);
			}
			controllers.put(controllerClass, controller);
			
			return controller;
		}
	}
}
