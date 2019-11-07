import java.awt.*;

public class Volvo240 extends Car {

	private final static double trimFactor = 1.25;

	public Volvo240() {
		setColor(Color.BLACK);
		setNrDoors(4);
		setEnginePower(100);
		setModelName("Volvo240");
		stopEngine();
	}

	public void startEngine() {
		setCurrentSpeed(0.1);
	}

	public void stopEngine() {
		setCurrentSpeed(0);
	}

	public double speedFactor() {
		return getEnginePower() * 0.01 * trimFactor;
	}

	public void incrementSpeed(double amount) {
		setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
	}

	public void decrementSpeed(double amount) {
	    setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
	}
}
