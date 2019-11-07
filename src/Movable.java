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
    public void move();

    /**
     * Turns the object to the left depending on the current direction of the object.
     */
    public void turnLeft();

    /**
     * Turns the object to the right depending on the current direction of the object.
     */
    public void turnRight();
}
