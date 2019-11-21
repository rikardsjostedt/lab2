/**
 * Represents a CarTransport
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class CarTransport extends Truck implements Movable {

	private Ramp ramp;

	/**
	 * Constructor for class CarTransport, sets initial values and calls super. Also creates a ramp for the vehicle with storage.
	 *
	 * @param x the x coordinate for the CarTransport to be placed
	 * @param y the y coordinate for the CarTransport to be placed
	 * @param maxSpeed
	 */
	public CarTransport(double x, double y, int maxSpeed) {
		super(x, y, maxSpeed);
		this.ramp = new Ramp(this, 10);
	}

	/**
	 * Calls super to incrementSpeed as long as the supplied amount is in the interval [0, 1] and the ramp is up. And it moves the vehicle forward with its content on the ramp.
	 *
	 * @param amount the amount to increase the speed with
	 * @see Truck#gas(double)
	 */
	@Override
	public void gas(double amount) {
		if (!ramp.isDown()) {
			super.gas(amount);
			ramp.updateCargoPosition();
		}
	}

	/**
	 * Calls super to decrementSpeed as long as the supplied amount is in the interval [0, 1] and the ramp is up. And it moves the vehicle forward with its content on the ramp.
	 *
	 * @param amount the amount to decrease the speed with
	 * @see Truck#gas(double)
	 */
	@Override
	public void brake(double amount) {
		super.brake(amount);
		ramp.updateCargoPosition();
	}
}
