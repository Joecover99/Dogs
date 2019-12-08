package dogs;

import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;

public class ApplicationSeeder {
	public static void run() {
		Client Corrine = new Client("Corrine", "Dion", "897-472-5018");
		Client Bianca = new Client("Bianca", "Licorne", "117-142-0468");
		Client Simon = new Client("Simon", "Deschamps", "825-972-1232");
		Client Alexandre = new Client("Alexandre", "Potvin", "835-986-6255");
		Client Serge = new Client("Serge", "Ontario", "248-985-1543");
		
		Corrine.persist();
		Bianca.persist();
		Simon.persist();
		Alexandre.persist();
		Serge.persist();
		
		new Dog("Fido", Breed.BEAGLE, Corrine).persist();
		new Dog("Molly", Breed.BULLDOG, Bianca).persist();
		new Dog("Maiylo", Breed.CAUCASIAN_SHEPERD, Simon).persist();
		new Dog("Toby", Breed.PIT_BULL, Alexandre).persist();
		new Dog("Bin", Breed.BLOODHOUND, Serge).persist();
		new Dog("Max", Breed.MIXED, null).persist();
	}
}
