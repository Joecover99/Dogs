package mocks;

import abstracts.Controller;
import interfaces.IModel;

@SuppressWarnings("rawtypes")
public class SpyController extends Controller {
	
	public Verb usedVerb;
	public IModel usedArgument;
	
	@Override protected void index() {
		this.usedVerb = Verb.Index;
	}
	
	@Override protected void create() {
		this.usedVerb = Verb.Create;
	}
	
	@Override protected void store(IModel item) {
		this.usedVerb = Verb.Store;
		this.usedArgument = item;
	}
	
	@Override protected void show(IModel item) {
		this.usedVerb = Verb.Show;
		this.usedArgument = item;
	}
	
	@Override protected void edit(IModel item) { 
		this.usedVerb = Verb.Edit;
		this.usedArgument = item;
	}
	
	@Override protected void update(IModel item) {
		this.usedVerb = Verb.Update;
		this.usedArgument = item;
	}
	
	@Override protected void destroy(IModel item) {
		this.usedVerb = Verb.Destroy;
		this.usedArgument = item;
	}
};
