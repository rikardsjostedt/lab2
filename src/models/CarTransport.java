package models;

import java.awt.*;

/**
 * Represents a models.CarTransport
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class CarTransport extends Truck {

	private Ramp<Car> ramp;

	/**
	 * Constructor for class models.CarTransport, sets initial values and calls super. Also creates a ramp for the vehicle with storage.
	 *
	 * @param x the x-coordinate of the car transport
	 * @param y the y-coordinate of the car transport
	 */
	public CarTransport(double x, double y) {
		super(Color.BLUE, 2, 90, "LångtradarN", x, y);
		this.ramp = new Ramp(this, 10);
	}

	/**
	 * Calls super to incrementSpeed as long as the supplied amount is in the interval [0, 1] and the ramp is up. And it moves the vehicle forward with its content on the ramp.
	 *
	 * @param amount the amount to increase the speed with
	 * @see Vehicle#gas(double)
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
	 * @see Vehicle#brake(double)
	 */
	@Override
	public void brake(double amount) {
		super.brake(amount);
		ramp.updateCargoPosition();
	}

	public Ramp getRamp() {
		return this.ramp;
	}
}
