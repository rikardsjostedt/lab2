import java.awt.*;

/**
 * Represents a Scania
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class Scania extends Truck {

	private Flatbed flatbed;

	/**
	 * Constructor for the Scania, sets initital values and calls super
	 * @param x the x coordinate for the Scania to be placed
	 * @param y the y coordinate for the Scania to be placed
	 * @see Truck
	 */
	public Scania(int x, int y) {
		super(Color.BLUE, 2, 90, "ScaniaTruckN", x, y);
		this.flatbed = new Flatbed(this,0, 70);
	}

	/**
	 * Calculates the Scania's speed factor
	 *
	 * @return the speed factor of the Scania
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

/**
 * Represents a Flatbed
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
class Flatbed {

	public final int maxTilt;
	public final int minTilt;
	private int currentTilt;
	private Scania truck;

	/**
	 * Constructor for the Flatbed, sets initial values
	 *
	 * @param truck the truck to connect the flatbed to
	 * @param minTilt the angle of the flatbed where it is down (initial value/drivable position)
	 * @param maxTilt the maximum angle that the flatbed can tilt to
	 */
	public Flatbed(Scania truck, int minTilt, int maxTilt) {
		this.minTilt = minTilt;
		this.maxTilt = maxTilt;
		this.currentTilt = 0;
		this.truck = truck;
	}

	/**
	 * Tells if the flatbed is down by comparing currentTilt with the flatbeds minTilt
	 *
	 * @return a boolean if the flatbed is down or not
	 */
	public boolean isDown() {
		return currentTilt == minTilt;
	}

	/**
	 * Changes the tilt of the flatbed to the desired angle as long as it is within the flatbed's limitations
	 *
	 * @param tilt the desired tilt of the flatbed
	 */
	public void changeTilt(int tilt) {
		if (tilt <= maxTilt && tilt >= minTilt && truck.getCurrentSpeed() == 0)
			currentTilt = tilt;
	}

	/**
	 * @return the current tilt attribute
	 */
	public int getCurrentTilt()
	{
		return currentTilt;
	}
}
