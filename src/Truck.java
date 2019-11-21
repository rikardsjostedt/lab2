public abstract class Truck implements Movable {

	private MoveHelper moveHelper;
	private int maxSpeed;


	public Truck(double x, double y, int maxSpeed) {
		this.moveHelper = new MoveHelper(x, y, this);
		this.maxSpeed = maxSpeed;
	}

	/**
	 * Calls incrementSpeed as long as the supplied amount is in the interval [0, 1]
	 *
	 * @param amount the amount to increase speed with
	 */
	public void gas(double amount) {
		if (amount > 1 || amount < 0)
			return;
		moveHelper.incrementSpeed(amount);
		moveHelper.move();
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 *
	 * @param amount the amount to decrease speed with
	 */
	public void brake(double amount) {
		if (amount > 1 || amount < 0)
			return;
		moveHelper.decrementSpeed(amount);
		moveHelper.move();
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public double getX() {
		return moveHelper.getX();
	}

	public double getY() {
		return moveHelper.getY();
	}

	public double getCurrentSpeed() {
		return moveHelper.getCurrentSpeed();
	}

	public double speedFactor() {
		return 1;
	}
}