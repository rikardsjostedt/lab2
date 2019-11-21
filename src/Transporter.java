/**
 * Interface for a Transporter of something, has a storage of objects implementing Transportable
 *
 * @param <T>
 */
public interface Transporter<T> extends IStorage<Transportable> {

	/**
	 * Method for updating the position of the Transportables loaded in the Transporters storage
	 *
	 */
	void updateCargoPosition();

	double getX();

	double getY();

}