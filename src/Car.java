import java.awt.*;

public abstract class Car extends MotorizedVehicle {

	private int nrDoors;

	/**
	 * Initializes the direction of the car.
	 *
	 * @param color
	 * @param nrDoors
	 * @param enginePower
	 * @param modelName
	 */
	public Car(Color color, int nrDoors, double enginePower, String modelName, double width, double length) {
		super(color, enginePower, modelName, width, length);
		this.nrDoors = nrDoors;
	}

	/**
	 *
	 * @return the nrDoors attribute
	 */
	public int getNrDoors(){
		return nrDoors;
	}
}