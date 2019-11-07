import java.awt.*;

/**
 * Represents the concept of a car.
 * @author Albin Landgren
 * @version 1.0.0
 * @since 1.0.0
 */
abstract public class Car implements Movable {

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
	public Car() {
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
	 * Sets the color attribute.
	 * @param clr the color to set
	 */
	public void setColor(Color clr){
		color = clr;
	}

	/**
	 * Sets the nrDoors attribute.
	 * @param doors the nrDoors to set
	 */
	public void setNrDoors(int doors) {
		nrDoors = doors;
	}

	/**
	 * Sets the modelName attribute.
	 * @param name the modelName to set
	 */
	public void setModelName(String name) {
		modelName = name;
	}

	/**
	 * Sets the enginePower.
	 * @param power the enginePower to set
	 */
	public void setEnginePower(double power) {
		enginePower = power;
	}

	/**
	 *
	 * @param d the direction to set
	 */
	public void setDirection(Direction d) {
		direction = d;
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
	public void setCurrentSpeed(double spd) {
		if (spd > enginePower || spd < 0)
			return;
		currentSpeed = spd;
	}

	/**
	 * Abstract method for incrementing speed
	 * @param d the amount to increment speed with
	 */
	public abstract void incrementSpeed(double d);

	/**
	 * Abstract method for decrementing speed
	 * @param d the amount to decrement speed with
	 */
	public abstract void decrementSpeed(double d);

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
