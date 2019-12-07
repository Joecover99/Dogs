package dogs.models;

import abstracts.AbstractModel;

public class Breed extends AbstractModel {
	private String breed;
	
	public String getBreed() {
		return this.breed;
	}
	
	public void setName(String breed) {
		this.breed = breed;
	}
}
