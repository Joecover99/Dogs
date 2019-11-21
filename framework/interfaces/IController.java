package interfaces;

import exceptions.UnimplementedRouteException;

/**
 * A generic "Resource Controller" interface to implement the conventional CRUD routes in a MVC context.
 * @author Benjamin Bergeron
 * @see CRUD, Resource Controller
 * @param <T>
 */
public interface IController<T extends IModel> {
	
	public static enum Verb {
		Index,
		Create,
		Store,
		Show,
		Edit,
		Update,
		Destroy
	}
	default void invokeRoute(Verb verb) throws UnimplementedRouteException {
		this.invokeRoute(verb, null);
	}
	
	default void invokeRoute(Verb verb, T arguments) throws UnimplementedRouteException {
		switch(verb) {
		case Index:
			this.index();
			break;
		case Create:
			this.create();
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
		default:
			throw new UnimplementedRouteException();
		}
	}
	
	/**
	 * Invoke the view to display the index of the resource. In most case, a list of all currently available elements.
	 * @throws UnimplementedRouteException
	 */
	default void index() throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to display the item creation form.
	 * @throws UnimplementedRouteException
	 */
	default void create() throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Insert the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	default void store(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to display the given item.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	default void show(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Invoke the view to edit the given item.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	default void edit(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Update the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	default void update(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	/**
	 * Delete the given element in model.
	 * @param item
	 * @throws UnimplementedRouteException
	 */
	default void destroy(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
}
