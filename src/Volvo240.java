import java.awt.*;

/**
 * Represents a Volvo240
 * @author  Alexander Jyborn
 * @version 1.0
 * @since   1.0
 */
public class Volvo240 extends Car {

	private final static double trimFactor = 1.25;

	/**
	 *  Constructor for Volvo240, sets initial values
	 */
	public Volvo240() {
		setColor(Color.BLACK);
		setNrDoors(4);
		setEnginePower(100);
		setModelName("Volvo240");
		stopEngine();
	}

	/**
	 * Calculates the cars speedFactor based on the enginePower and trimFactor
	 *
	 * @return  the cars speedFactor
	 */
	public double speedFactor() {
		return getEnginePower() * 0.01 * trimFactor;
	}

	/**
	 * @param  amount an amount of how much the speed should increase based of the speedFactor
	 * @see    #speedFactor()
	 */
	public void incrementSpeed(double amount) {
		setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
	}

	/**
	 * @param amount an amount of how much the speed should decrease based on the speedFactor
	 */
	public void decrementSpeed(double amount) {
	    setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
	}
}
