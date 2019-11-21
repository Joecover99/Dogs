package abstracts;

import exceptions.UnimplementedRouteException;
import interfaces.IController;
import interfaces.IModel;

public abstract class AbstractController<T extends IModel> implements IController<T> {
	
	public AbstractController() {}
	
	@Override
	public void index() throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	@Override
	public void create() throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	@Override
	public void store(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	
	@Override
	public void show(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	@Override
	public void edit(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	@Override
	public void update(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
	@Override
	public void destroy(T item) throws UnimplementedRouteException {
		throw new UnimplementedRouteException();
	}
}
