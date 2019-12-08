package dogs.models;

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
	private Client owner;
	
	public Dog(String name, Breed breed, Client owner) {
		super();
		this.name = name;
		this.breed = breed;
		this.owner = owner;
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

	public Client getOwner() {
		return this.owner;
	}
	
	public String getOwnerName() {
		return this.owner != null ? this.owner.toString() : NO_OWNER_NAME;
	}
}
