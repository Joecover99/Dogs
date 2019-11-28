package mocks;

import abstracts.Controller;
import interfaces.IModel;

@SuppressWarnings("rawtypes")
public class SpyController extends Controller {
	
	public Verb usedVerb;
	public IModel usedArgument;
	
	@Override protected void index(Object arguments) {
		this.usedVerb = Verb.Index;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void create(Object arguments) {
		this.usedVerb = Verb.Create;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void store(Object arguments) {
		this.usedVerb = Verb.Store;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void show(Object arguments) {
		this.usedVerb = Verb.Show;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void edit(Object arguments) { 
		this.usedVerb = Verb.Edit;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void update(Object arguments) {
		this.usedVerb = Verb.Update;
		this.usedArgument = (IModel) arguments;
	}
	
	@Override protected void destroy(Object arguments) {
		this.usedVerb = Verb.Destroy;
		this.usedArgument = (IModel) arguments;
	}
};
