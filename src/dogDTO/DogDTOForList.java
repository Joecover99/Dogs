package dogDTO;

public class DogDTOForList {

	public static DogDTOForList dogDTO;
	public String name;
	public String breed;
	public int id;

	public DogDTOForList(int id, String name, String breed) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.breed = breed;
		this.id = id;
	}

}
