import com.sun.jdi.connect.Transport;

import javax.xml.crypto.dsig.TransformService;

public class MoveHelper implements Movable
{
    private double x;
    private double y;
    private Direction direction;
    private double currentSpeed; // The current speed of the car
    private Transportable entity;


    public MoveHelper(int x, int y, Transportable entity)
    {
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
    }

    private void setCurrentSpeed(double spd) {
        if (spd > entity.getMaxSpeed() || spd < 0)
            return;
        currentSpeed = spd;
    }

    /**
     * Increases the speed of the car based on the current speed and the speedFactor
     *
     * @param  amount an amount of how much the speed should increase based on the speedFactor
     */
    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(currentSpeed + entity.speedFactor() * amount, entity.getMaxSpeed()));
    };

    /**
     * Decreases the current speed of the car based on the current speed and the speed factor.
     *
     * @param amount an amount of how much the speed should decrease (based on the speedFactor)
     */
    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(currentSpeed - entity.speedFactor() * amount, 0));
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
     * Moves the car based on the direction and currentSpeed attributes
     */
    public void move() {
        x += direction.getX() * currentSpeed;
        y += direction.getY() * currentSpeed;
    }

    /**
     * Moves the car in the reverse direction
     */
    public void reverse() {
        x -= direction.getX() * currentSpeed;
        y -= direction.getY() * currentSpeed;
    }

    public void move(Direction direction)
    {

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