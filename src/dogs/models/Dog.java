package dogs.models;

import abstracts.AbstractModel;

public class Dog extends AbstractModel {
	
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
	
	public Dog(String name, Breed breed) {
		super();
		this.name = name;
		this.breed = breed;
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

	@Override
	public void persist() {
		// TODO Auto-generated method stub
		
	}

}
