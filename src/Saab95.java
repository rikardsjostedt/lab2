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
    public Saab95(int x, int y){
        super(x, y, 125);
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
    public double speedFactor(){
        double turbo = turboOn ? 1.3 : 1;
        return getMaxSpeed() * 0.01 * turbo;
    }

}
