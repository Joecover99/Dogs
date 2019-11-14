package dogs.model;

import java.awt.Component;

public class Dog {  // La classe est tr�s simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	public static int nextId = 1;
	
	private int id;
	private Component name;
	private Component breed;  // Id�alement faire une classe Breed (pr�f�rer � une enum)
	
	public Dog(Component name, Component breed) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		this.id = nextId;
		incrementNextId();
		this.name = name;
		this.breed = breed;
	}

	private void incrementNextId() {
		// TODO Auto-generated method stub
		nextId++;
	}

	public int getId() {
		return this.id;
	}
	
	public Component getName() {
		return name;
	}
	public void setName(Component name) {
		this.name = name;
	}

	public Component getBreed() {
		return breed;
	}
	public void setBreed(Component breed) {
		this.breed = breed;
	}

}
