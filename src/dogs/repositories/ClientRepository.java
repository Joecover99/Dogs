package dogs.repositories;

import java.util.List;
import java.util.function.Predicate;

import abstracts.BasicRepository;
import dogs.models.Client;

public class ClientRepository extends BasicRepository<Client> {
	
	/**
	 * @param string
	 * @return All clients whom's first name or last name match the given string
	 */
	public List<Client> selectByName(String string) {
		return super.select(new Predicate<Client>() {
			@Override
			public boolean test(Client c) {
				return c.getLastName().contains(string) ||
						c.getLastName().contains(string);
			}
		});
	}
}
