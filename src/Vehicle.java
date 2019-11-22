import java.awt.*;

public abstract class Vehicle implements Movable {

	private double x;
	private double y;
	private Direction direction;
	private double currentSpeed;
	private double maxSpeed;
	private Color color;
	private int nrDoors;
	private String modelName;

	/**
	 *
	 * @param color the color of the vehicle
	 * @param nrDoors the number of doors for the vehicle
	 * @param maxSpeed the maximum speed attainable for the vehicle
	 * @param modelName the model name of the vehicle
	 * @param x the x-coordinate of the vehicle
	 * @param y the y-coordinate of the vehicle
	 */
	public Vehicle(Color color, int nrDoors, double maxSpeed, String modelName, double x, double y) {
		this.color = color;
		this.nrDoors = nrDoors;
		this.maxSpeed = maxSpeed;
		this.modelName = modelName;
		this.x = x;
		this.y = y;
		this.direction = Direction.NORTH;
	}

	/**
	 * Sets the current speed of the entity if the speed sent to the method is within the allowed range
	 *
	 * @param spd the speed to be set
	 */
	private void setCurrentSpeed(double spd) {
		if (spd > maxSpeed || spd < 0)
			return;
		currentSpeed = spd;
	}

	/**
	 * Increases the speed based on the current speed and the speedFactor of the entity.
	 *
	 * @param amount an amount of how much the speed should increase (based on the speedFactor)
	 */
	private void incrementSpeed(double amount) {
		setCurrentSpeed(Math.min(currentSpeed + speedFactor() * amount, maxSpeed));
	}

	/**
	 * Calls incrementSpeed as long as the supplied amount is in the interval [0, 1] and moves the vehicle forward
	 *
	 * @param amount the amount to increase the speed with
	 */
	public void gas(double amount) {
		if (amount > 1 || amount < 0)
			return;
		incrementSpeed(amount);
		move();
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 *
	 * @param amount the amount to decrease the speed with
	 */
	public void brake(double amount) {
		if (amount > 1 || amount < 0)
			return;
		decrementSpeed(amount);
		move();
	}


	/**
	 * Starts the engine increasing the speed 0.1
	 */
	public void startEngine() {
		incrementSpeed(0.1);
	}

	/**
	 * Decreases the current speed based on the current speed and the speed factor of the entity.
	 *
	 * @param amount an amount of how much the speed should decrease (based on the speedFactor)
	 */
	private void decrementSpeed(double amount) {
		setCurrentSpeed(Math.max(currentSpeed - speedFactor() * amount, 0));
	}

	/**
	 * @return the x attribute
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y attribute
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return the direction attribute
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Moves the entity based on the direction and currentSpeed attributes
	 */
	public void move() {
		x += direction.getX() * currentSpeed;
		y += direction.getY() * currentSpeed;
	}

	/**
	 * @return the currentSpeed attribute
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 *
	 * @return the maxSpeed attribute of the vehicle
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Calls the move function with the left attribute
	 */
	public void turnLeft() {
		direction = direction.previous();
	}

	/**
	 * Calls the move function with the right attribute
	 */
	public void turnRight() {
		direction = direction.next();
	}

	/**
	 * Moves the entity to certain coordinates
	 *
	 * @param x the x coordinate to move the entity to
	 * @param y the y coordinate to move the entity to
	 */
	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
