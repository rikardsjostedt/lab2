/**
 * Helps movable entities to move
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class MoveHelper {
	private double x;
	private double y;
	private Direction direction;
	private double currentSpeed; // The current speed of the car
	private Movable entity;

	/**
	 * Constructor for the MoveHelper, sets initial values.
	 *
	 * @param x the x coordinate for the entity
	 * @param y the y coordinate for the entity
	 * @param entity the entity the helper should help move
	 */
	public MoveHelper(double x, double y, Movable entity) {
		this.entity = entity;
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
		if (spd > entity.getMaxSpeed() || spd < 0)
			return;
		currentSpeed = spd;
	}

	/**
	 * Increases the speed based on the current speed and the speedFactor of the entity.
	 *
	 * @param amount an amount of how much the speed should increase (based on the speedFactor)
	 */
	protected void incrementSpeed(double amount) {
		setCurrentSpeed(Math.min(currentSpeed + entity.speedFactor() * amount, entity.getMaxSpeed()));
	}

	;

	/**
	 * Decreases the current speed based on the current speed and the speed factor of the entity.
	 *
	 * @param amount an amount of how much the speed should decrease (based on the speedFactor)
	 */
	protected void decrementSpeed(double amount) {
		setCurrentSpeed(Math.max(currentSpeed - entity.speedFactor() * amount, 0));
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
