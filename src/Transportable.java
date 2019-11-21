/**
 * Methods required by anything that should be able to be transported
 *
 */
public interface Transportable {

	/**
	 * Method for setting the transportables position on the transport
	 *
	 * @param transporter transporting the transportable
	 */
	void moveWithTransporter(Transporter transporter);

	/**
	 * @return if the transportable is loaded onto a transport
	 */
	boolean isLoaded();

	/**
	 * Method for setting the if the transportable is loaded onto a transport or not
	 *
	 * @param loaded
	 */
	void setLoaded(boolean loaded);

	double getX();
	double getY();
}
