package models;

/**
 * Interface for a models.Transporter of something, has a storage of objects implementing models.Transportable
 *
 * @param <T>
 */
public interface Transporter<T extends Transportable> extends IStorage<T> {

	/**
	 * Method for updating the position of the Transportables loaded in the Transporters storage
	 *
	 */
	void updateCargoPosition();

	/**
	 *
	 * @return the x attribute of the transporter
	 */
	double getX();

	/**
	 *
	 * @return the y attribute of the transporter
	 */
	double getY();

	/**
	 * Adds the
	 * @param t the entity to be loaded
	 */
	void load(T t);

	T unload ();

}