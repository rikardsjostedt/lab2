import java.awt.*;

/**
 * Represents a Saab 9.5
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class Saab95 extends Car implements Turbo{
    private boolean turboOn;

    /**
     * Constructor for class Saab95. Automatically sets initial values for the object.
     */
    public Saab95(){
        setColor(Color.RED);
        setNrDoors(2);
        setEnginePower(125);
        setModelName("Saab95");
        stopEngine();
    }

    /**
     * Turns on the turbo.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the turbo.
     */
    public void setTurboOff(){
	    turboOn = false;
    }


    /**
     * Calculates the cars' speed factor by checking if the turbo is on and then multiplying with the engine power.
     *
     * @return the speed factor of the car
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Increases the current speed of the car based on the current speed and the speed factor.
     *
     * @param amount an amount of how much the speed should increase (based on the accelerator)
     */
    public void incrementSpeed(double amount){
        if (getCurrentSpeed() + speedFactor() * amount > getCurrentSpeed())
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decreases the current speed of the car based on the current speed and the speed factor.
     *
     * @param amount an amount of how much the speed should decrease (based on the brake)
     */
    public void decrementSpeed(double amount){
        if (getCurrentSpeed() - speedFactor() * amount < getCurrentSpeed())
            setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
}
