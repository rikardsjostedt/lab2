package models;

import java.awt.*;

public abstract class Truck extends Vehicle {

	/**
	 *
	 * @param color the color of the vehicle
	 * @param nrDoors the number of doors for the vehicle
	 * @param maxSpeed the maximum speed attainable for the vehicle
	 * @param modelName the model name of the vehicle
	 * @param x the x-coordinate of the vehicle
	 * @param y the y-coordinate of the vehicle
	 */
	public Truck(Color color, int nrDoors, double maxSpeed, String modelName, double x, double y) {
		super(color, nrDoors, maxSpeed, modelName, x, y);
	}

	public double speedFactor() {
		return 1;
	}

}