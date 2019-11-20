/**
 * Methods required for movable objects in order to move.
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Movable
{
    /**
     * Moves the object forward.
     */
    void move(Direction direction);

    /**
     * Turns the object to the left depending on the current direction of the object.
     */
    void turnLeft();

    /**
     * Turns the object to the right depending on the current direction of the object.
     */
    void turnRight();
}
