package models;

import java.awt.*;

/**
 * Represents a models.Volvo240
 * @author  Alexander Jyborn
 * @version 1.0.0
 * @since   1.0.0
 */
public class Volvo240 extends Car {

	private final static double trimFactor = 1.25;

	/**
	 *  Constructor for models.Volvo240, sets initial values
	 */
	public Volvo240(double x, double y) {
		super(Color.RED, 4, 145, "TvåFörti", x, y);
	}

	/**
	 * Calculates the cars speedFactor based on the enginePower and trimFactor
	 *
	 * @return  the cars speedFactor
	 */
	public double speedFactor() {
		return getMaxSpeed() * 0.01 * trimFactor;
	}

}
