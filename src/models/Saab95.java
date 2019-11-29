package models;

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
     * Constructor for class models.Saab95. Automatically sets initial values for the object.
     * @param x the x-coordinate of the models.Saab95
     * @param y the y-coordinate of the models.Saab95
     */
    public Saab95(double x, double y) {
        super(Color.BLUE, 4, 180, "models.Saab95", x, y);
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
     * Calculates the cars' speed factor by checking if the turbo is on.
     *
     * @return the speed factor of the car
     */
    public double speedFactor() {
        double turbo = turboOn ? 1.3 : 1;
        return getMaxSpeed() * 0.01 * turbo;
    }

}
