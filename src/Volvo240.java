import java.awt.*;

/**
 * Represents a Volvo240
 * @author  Alexander Jyborn
 * @version 1.0.0
 * @since   1.0.0
 */
public class Volvo240 extends Car {

	private final static double trimFactor = 1.25;

	/**
	 *  Constructor for Volvo240, sets initial values
	 */
	public Volvo240() {
		super(Color.BLACK, 4, 100, "Volvo240");
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

}
