import java.awt.*;

public abstract class Car implements Movable, Transportable {

	private MoveHelper moveHelper;
	private int maxSpeed;
	private boolean loaded;

	public Car(int x, int y, int maxSpeed) {
		this.moveHelper = new MoveHelper(x, y, this);
		this.maxSpeed = maxSpeed;
		this.loaded = false;
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

	public void moveWithTransporter(Transporter transporter) {
		moveHelper.moveTo(transporter.getX(), transporter.getY());
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public double getX() {
		return moveHelper.getX();
	}

	public double getY() {
		return moveHelper.getY();
	}
}