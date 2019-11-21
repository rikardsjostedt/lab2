public class Scania extends Truck {

	private Flatbed flatbed;

	public Scania(int x, int y) {
		super(x, y, 90);
		this.flatbed = new Flatbed(this,0, 70);
	}

	public double speedFactor() {
		return getMaxSpeed() * 0.01;
	}

	@Override
	public void gas(double amount) {
		if (flatbed.isDown())
			super.gas(amount);
	}
}

class Flatbed {

	private int maxTilt;
	private int minTilt;
	private int currentTilt;
	private Scania truck;

	public Flatbed(Scania truck, int minTilt, int maxTilt) {
		this.minTilt = minTilt;
		this.maxTilt = maxTilt;
		this.currentTilt = 0;
		this.truck = truck;
	}

	public boolean isDown() {
		return currentTilt == minTilt;
	}

	/**
	 * Stepper motor
	 * @param tilt new tilt value for flatbed
	 */
	public void changeTilt(int tilt) {
		if (tilt <= maxTilt && tilt >= minTilt && truck.getCurrentSpeed() == 0)
			currentTilt = tilt;
	}
}
