/**
 * Represents the concept of a car
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Car implements Movable, Transportable {

	private MoveHelper moveHelper;
	private int maxSpeed;
	private boolean loaded;

	/**
	 * Constructor for class Car, sets inital values and calls super.
	 *
	 * @param x the x coordinate for the car to be placed
	 * @param y the y coordinate for the car to be placed
	 * @param maxSpeed the maximum speed the car can achieve
	 */
	public Car(int x, int y, int maxSpeed) {
		this.moveHelper = new MoveHelper(x, y, this);
		this.maxSpeed = maxSpeed;
		this.loaded = false;
	}

	/**
	 * Calls incrementSpeed as long as the supplied amount is in the interval [0, 1] and moves the car forward
	 *
	 * @param amount the amount to increase the speed with
	 */
	public void gas(double amount) {
		if (amount > 1 || amount < 0)
			return;
		moveHelper.incrementSpeed(amount);
		moveHelper.move();
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 *
	 * @param amount the amount to decrease the speed with
	 */
	public void brake(double amount) {
		if (amount > 1 || amount < 0)
			return;
		moveHelper.decrementSpeed(amount);
		moveHelper.move();
	}

	/**
	 * @return the maxSpeed attribute
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Moves the car to the location the transporter is currently at (when the car is loaded)
	 *
	 * @param transporter the transporter the car is loaded onto
	 */
	public void moveWithTransporter(Transporter transporter) {
		if(loaded)
			moveHelper.moveTo(transporter.getX(), transporter.getY());
	}

	/**
	 * Sets the loaded attribute
	 *
	 * @param loaded if the car is loaded or not
	 */
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	/**
	 * @return the loaded attribute
	 */
	public boolean isLoaded() {
		return loaded;
	}

	/**
	 * Gets the x attribute for the cars' moveHelper
	 *
	 * @return the x attribute
	 */
	public double getX() {
		return moveHelper.getX();
	}

	/**
	 * Gets the y attribute for the cars' moveHelper
	 *
	 * @return the y attribute
	 */
	public double getY() {
		return moveHelper.getY();
	}
}