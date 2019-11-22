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
	 * @return the maximum speed for the entity
	 */
	int getMaxSpeed();

	/**
	 * @return the speed factor for the entity
	 */
	double speedFactor();

	/**
	 * Moves the entity
	 */
	void move();
}
