package dogs;

import dogs.models.Client;
import dogs.models.Dog;
import dogs.models.Dog.Breed;
import interfaces.IRepository;

public class ApplicationSeeder {
	private ApplicationSeeder() {}
	
	public static void run(IRepository<Dog> dogRepository, IRepository<Client> clientRepository) {
		Client Corrine = new Client("Corrine", "Dion", "897-472-5018");
		Client Bianca = new Client("Bianca", "Licorne", "117-142-0468");
		Client Simon = new Client("Simon", "Deschamps", "825-972-1232");
		Client Alexandre = new Client("Alexandre", "Potvin", "835-986-6255");
		Client Serge = new Client("Serge", "Ontario", "248-985-1543");
		
		clientRepository.insert(Corrine);
		clientRepository.insert(Bianca);
		clientRepository.insert(Simon);
		clientRepository.insert(Alexandre);
		clientRepository.insert(Serge);
		
		dogRepository.insert(new Dog("Fido", Breed.BEAGLE, Corrine));
		dogRepository.insert(new Dog("Molly", Breed.BULLDOG, Bianca));
		dogRepository.insert(new Dog("Maiylo", Breed.CAUCASIAN_SHEPERD, Simon));
		dogRepository.insert(new Dog("Toby", Breed.PIT_BULL, Alexandre));
		dogRepository.insert(new Dog("Bin", Breed.BLOODHOUND, Serge));
		dogRepository.insert(new Dog("Max", Breed.MIXED, null));
	}
}
