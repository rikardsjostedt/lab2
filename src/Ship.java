import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ship implements Transporter<Transportable>, Movable {

	private List<Transportable> transportables = new ArrayList<>();
	private MoveHelper moveHelper;
	private final int maxSpeed;
	private final double speedFactor;

	public Ship(int x, int y) {
		moveHelper = new MoveHelper(x, y, this);
		maxSpeed = 50;
		speedFactor = 1.2;
	}

	public void updateCargoPosition() {
		for (Transportable t : transportables) {
			t.moveWithTransporter(this);
		}
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
		updateCargoPosition();
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
		updateCargoPosition();
	}

	public double getX() {
		return moveHelper.getX();
	}

	public double getY() {
		return moveHelper.getY();
	}

	public void load(Transportable transportable) {
		if(!transportable.isLoaded()) {
			transportables.add(transportable);
			transportable.setLoaded(true);
		}
	}

	public Transportable unload() {
		Transportable unloaded = transportables.remove(0);
		unloaded.setLoaded(false);
		return unloaded;
	}

	public Collection<Transportable> getStoredItems() {
		return transportables;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public double speedFactor() {
		return speedFactor;
	}
}
