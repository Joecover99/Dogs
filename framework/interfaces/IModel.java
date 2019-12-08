package interfaces;

public interface IModel {
	int getId();
	void setId(int id);
	
	/**
	 * Save current instance as a new instance in repository
	 */
	void persist();
	void save();
}
