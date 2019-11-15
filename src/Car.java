import java.awt.*;

/**
 * Represents the concept of a car.
 * @author Albin Landgren
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Car implements Movable {

	private int nrDoors; // Number of doors on the car
	private double enginePower; // Engine power of the car
	private double currentSpeed; // The current speed of the car
	private Color color; // Color of the car
	private String modelName; // The car model name
	private double x;
	private double y;
	private Direction direction;

	/**
	 * Initializes the direction of the car.
	 */
	public Car(Color color, int nrDoors, double enginePower, String modelName) {
		this.color = color;
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.modelName = modelName;
		direction = Direction.NORTH;
	}

	/**
	 *
	 * @return the nrDoors attribute
	 */
	public int getNrDoors(){
		return nrDoors;
	}

	/**
	 *
	 * @return the enginerPower attribute
	 */
	public double getEnginePower(){
		return enginePower;
	}

	/**
	 *
	 * @return the currentSpeed attribute
	 */

	public double getCurrentSpeed(){
		return currentSpeed;
	}

	/**
	 *
	 * @return the color attribute
	 */
	public Color getColor(){
		return color;
	}

	/**
	 *
	 * @return the x attribute
	 */
	public double getX() {
		return x;
	}

	/**
	 *
	 * @return the y attribute
	 */
	public double getY() {
		return y;
	}

	/**
	 *
	 * @return the direction attribute
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Starts the engine.
	 */
	public void startEngine(){
		currentSpeed = 0.1;
	}

	/**
	 * Stops the engine.
	 */
	public void stopEngine(){
		currentSpeed = 0;
	}

	/**
	 * Sets the current speed if the value is in the interval [0, enginePower]
	 * @param spd the currentSpeed to set
	 */
    private void setCurrentSpeed(double spd) {
		if (spd > enginePower || spd < 0)
			return;
		currentSpeed = spd;
	}

	/**
	 * Abstract method should calculate the cars speedFactor
	 *
	 * @return  the cars speedFactor
	 */
	protected abstract double speedFactor();

	/**
	 * Increases the speed of the car based on the current speed and the speedFactor
	 *
	 * @param  amount an amount of how much the speed should increase based on the speedFactor
	 * @see    #speedFactor()
	 */
	private void incrementSpeed(double amount) {
		setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower));
	};

	/**
	 * Decreases the current speed of the car based on the current speed and the speed factor.
	 *
	 * @param amount an amount of how much the speed should decrease (based on the speedFactor)
	 * @see    #speedFactor()
	 */
	private void decrementSpeed(double amount) {
		setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
	}

	/**
	 * Calls incrementSpeed as long as the supplied amount is in the interval [0, 1]
	 * @param amount the amount to increase speed with
	 */
	public void gas(double amount){
		if (amount > 1 || amount < 0)
			return;
		incrementSpeed(amount);
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 * @param amount the amount to decrease speed with
	 */
	public void brake(double amount){
		if (amount > 1 || amount < 0)
			return;
		decrementSpeed(amount);
	}

	/**
	 * Moves the car based on the direction and currentSpeed attributes
	 * @param direction the direction to turn the car in
	 */
	public void move(Direction direction) {
		x += direction.getX() * currentSpeed;
		y += direction.getY() * currentSpeed;
	}

	/**
	 * Calls the move function with the left attribute
	 *
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

}
