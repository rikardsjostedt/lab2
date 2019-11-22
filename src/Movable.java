/**
 * Methods required for entities that are movable
 *
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 * @see MoveHelper
 */
public interface Movable {
	/**
	 * @return the maximum speed
	 */
	double getMaxSpeed();

	/**
	 * @return the speed factor
	 */
	double speedFactor();

	/**
	 * Moves the movable entity
	 */
	void move();

	/**
	 * Turns the entity to the left based on the current direction
	 */
	void turnLeft();

	/**
	 * Turns the entity to the right based on the current direction
	 */
	void turnRight();
}
