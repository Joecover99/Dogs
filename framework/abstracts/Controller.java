package abstracts;

import exceptions.NullRouteVerbException;
import exceptions.UnimplementedRouteException;
import interfaces.IModel;

/**
 * A generic "Resource Controller" abstract to implement the conventional CRUD-MVC pattern.
 * @see CRUD, Resource Controller
 * @param <T>
 */
public abstract class Controller<T extends IModel> {
	
	/**
	 * The 7 verbs of the CRUD-MVC resource pattern
	 */
	public static enum Verb {
		/**
		 * Invoke the view to display the index of the resource. In most case, a list of all currently available elements.
		 */
		Index,
		/**
		 * Invoke the view to display the item creation form.
		 */
		Create,
		/**
		 * Insert the given element in model.
		 */
		Store,
		/**
		 * Invoke the view to display the given item.
		 */
		Show,
		/**
		 * Invoke the view to edit the given item.
		 */
		Edit,
		/**
		 * Update the given element in model.
		 */
		Update,
		/**
		 * Delete the given element in model.
		 */
		Destroy
	}
	
	/**
	 * Invoke the controller's route corresponding to the given verb.
	 * @param verb
	 * @throws UnimplementedRouteException
	 */
	public final void invokeRoute(Verb verb) throws UnimplementedRouteException {
		this.invokeRoute(verb, null);
	}
	
	/**
	 * Invoke the controller's route corresponding to the given verb with the given parameter object.
	 * @param verb
	 * @param arguments
	 * @throws UnimplementedRouteException
	 */
	public final void invokeRoute(Verb verb, Object arguments) throws UnimplementedRouteException {
		if(verb == null) {
			throw new NullRouteVerbException();
		}
		
		switch(verb) {
		case Index:
			this.index(arguments);
			break;
		case Create:
			this.create(arguments);
			break;
		case Destroy:
			this.destroy(arguments);
			break;
		case Edit:
			this.edit(arguments);
			break;
		case Show:
			this.show(arguments);
			break;
		case Store:
			this.store(arguments);
			break;
		case Update:
			this.update(arguments);
			break;
		}
	}
	
	/**
	 * Invoke the view to display the index of the resource. In most case, a list of all currently available elements.
	 * @throws UnimplementedRouteException
	 */
	protected void index(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to display the item creation form.
	 * @throws UnimplementedRouteException
	 */
	protected void create(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Insert the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	protected void store(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to display the given item.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	protected void show(Object instance) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to edit the given item.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	protected void edit(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Update the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	protected void update(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Delete the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	protected void destroy(Object arguments) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
}
