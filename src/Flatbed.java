public class Flatbed {

	private final int minTilt = 0;
	private final int maxTilt = 70;
	private int currentTilt = 0;
	private double width;
	private double length;
	private Truck truck;

	public Flatbed(Truck truck, double width, double length) {
		this.truck = truck;
	}

	public void tilt(int degree) {
		if (truck.getCurrentSpeed() == 0 && degree <= maxTilt && degree >= minTilt) {
			currentTilt = degree;
		}
	}

	public int getCurrentTilt() {
		return currentTilt;
	}

	protected int getMinTilt() {
		return minTilt;
	}

	protected int getMaxTilt() {
		return maxTilt;
	}

	protected Truck getTruck() {
		return truck;
	}
}
