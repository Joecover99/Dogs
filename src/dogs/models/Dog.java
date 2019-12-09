package dogs.models;

import dogs.MainAppDogs;
import exceptions.ModelNotPersistedException;
import interfaces.IRepository;
import utils.Model;

@SuppressWarnings("serial")
public class Dog extends Model {
	
	public static final String NO_OWNER_NAME = "n/a";
	
	public static enum Breed {
		AIDI,
		PIT_BULL,
		CAUCASIAN_SHEPERD,
		GOLDEN_RETRIEVER,
		PUG,
		BORDER_COLLIE,
		BEAGLE,
		BLOODHOUND,
		BOSTON_TERRIER,
		BOXER,
		BRIARD,
		BULLDOG,
		CHOW_CHOW,
		MIXED
	}

	private String name;
	private Breed breed;
	private transient IClient owner;
	private int ownerId;
	
	public Dog(String name, Breed breed, IClient owner) {
		super();
		this.name = name;
		this.breed = breed;
		this.setOwner(owner);
	}
	
	public void setOwner(IClient owner) {
		this.owner = owner;
		this.ownerId = owner != null ? owner.getId() : IRepository.NULL_ID;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}
	
	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public IClient getOwner() {
		if(this.owner == null && this.ownerId != IRepository.NULL_ID) {
			try {
				this.owner = MainAppDogs.clientRepository.select(this.ownerId);
			} catch (ModelNotPersistedException e) {
				this.ownerId =IRepository.NULL_ID;
			}
		}
		return this.owner;
	}
	
	public String getOwnerName() {
		return this.owner != null ? this.owner.toString() : NO_OWNER_NAME;
	}
}
