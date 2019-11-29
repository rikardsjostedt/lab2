package models;

import java.awt.*;

/**
 * Represents the concept of a car
 *
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Car extends Vehicle implements Transportable {

	private boolean loaded;

	/**
	 *ge
	 * @param color the color of the car
	 * @param nrDoors the number of doors for the car
	 * @param maxSpeed the maximum speed attainable for the car
	 * @param modelName the model name of the car
	 * @param x the x-coordinate of the car
	 * @param y the y-coordinate of the car
	 */
	public Car(Color color, int nrDoors, double maxSpeed, String modelName, double x, double y) {
		super(color, nrDoors, maxSpeed, modelName, x, y);
		this.loaded = false;
	}

	/**
	 * Moves the car to the location the transporter is currently at (when the car is loaded)
	 *
	 * @param transporter the transporter the car is loaded onto
	 */
	public void moveWithTransporter(Transporter transporter) {
		if (loaded)
			moveTo(transporter.getX(), transporter.getY());
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

}