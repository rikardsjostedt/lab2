import java.awt.*;

abstract public class Car {

	private int nrDoors; // Number of doors on the car
	private double enginePower; // Engine power of the car
	private double currentSpeed; // The current speed of the car
	private Color color; // Color of the car
	private String modelName; // The car model name


	public Car() {

	}

	public int getNrDoors(){
		return nrDoors;
	}
	public double getEnginePower(){
		return enginePower;
	}

	public double getCurrentSpeed(){
		return currentSpeed;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(Color clr){
		color = clr;
	}

	public void setNrDoors(int doors) {
		nrDoors = doors;
	}

	public void setModelName(String name) {
		modelName = name;
	}

	public void setEnginePower(double power) {
		enginePower = power;
	}

	public void startEngine(){
		currentSpeed = 0.1;
	}

	public void stopEngine(){
		currentSpeed = 0;
	}

	public void setCurrentSpeed(double spd) {
		currentSpeed = spd;
	}

	public abstract void incrementSpeed(double d);

	public abstract void decrementSpeed(double d);

	// TODO fix this method according to lab pm
	public void gas(double amount){
		incrementSpeed(amount);
	}

	// TODO fix this method according to lab pm
	public void brake(double amount){
		decrementSpeed(amount);
	}

}
