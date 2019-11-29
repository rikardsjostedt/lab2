package models;

import java.awt.*;

/**
 * Represents a models.Scania
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class Scania extends Truck {

	private Flatbed flatbed;

	/**
	 * Constructor for the models.Scania, sets initital values and calls super
	 * @param x the x coordinate for the models.Scania to be placed
	 * @param y the y coordinate for the models.Scania to be placed
	 * @see Truck
	 */
	public Scania(int x, int y) {
		super(Color.BLUE, 2, 90, "ScaniaTruckN", x, y);
		this.flatbed = new Flatbed(this,0, 70);
	}

	/**
	 * Calculates the models.Scania's speed factor
	 *
	 * @return the speed factor of the models.Scania
	 */
	public double speedFactor() {
		return getMaxSpeed() * 0.01;
	}

	/**
	 * Makes sure the flatbed is down and then calls super to gas
	 *
	 * @param amount the amount to increase speed with
	 * @see Truck#gas(double)
	 */
	@Override
	public void gas(double amount) {
		if (flatbed.isDown())
			super.gas(amount);
	}

	/**
	 * @return the flatbed of the truck
	 */
	public Flatbed getFlatbed()
	{
		return flatbed;
	}
}