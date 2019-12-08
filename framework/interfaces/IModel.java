package interfaces;

import java.io.Serializable;

public interface IModel extends Serializable {
	
	/**
	 * @return The instance's id
	 */
	int getId();
	
	/**
	 * @param id
	 */
	void setId(int id);
}
