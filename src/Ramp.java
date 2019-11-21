import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * A class representing a transporter with a ramp that can be either up or down
 *
 */
public class Ramp implements Transporter<Car>{

	private boolean isDown;
	private Truck truck;
	private Deque<Transportable> transportables = new ArrayDeque<>();
	private int capacity;

	public Ramp(Truck t, int capacity) {
		this.isDown = false;
		this.capacity = capacity;
		this.truck = t;
	}

	public boolean isDown() {
		return isDown;
	}

	public void up() {
		this.isDown = false;
	}

	public void down() {
		this.isDown = true;
	}

	/**
	 * Updates the position of all transportables stored on the ramp
	 *
	 */
	public void updateCargoPosition() {
		for (Transportable t : transportables) {
			t.moveWithTransporter(this);
		}
	}

	public double getX() {
		return truck.getX();
	}

	public double getY() {
		return truck.getY();
	}

	/**
	 * Loads an object with the type transportable onto the ramp
	 *
	 * @param transportable the transportable unit to be transported
	 */
	public void load(Transportable transportable) {
		if(isDown && transportables.size() < capacity && !transportable.isLoaded() && closeby(transportable)) {
			transportables.addLast(transportable);
			transportable.setLoaded(true);
		}

	}

	/**
	 * Checks if the transportable about to be loaded is close to the ramp
	 *
	 * @param t
	 * @return if the transportable is closeby
	 */
	private boolean closeby(Transportable t) {
		if(t.getX() == truck.getX() && t.getY() == truck.getY())
			return true;
		return false;
	}

	/**
	 * Unloads the transportable last loaded onto the ramp
	 *
	 * @return the last transportable loaded onto the ramp
	 */
	public Transportable unload() {
		Transportable removed =  transportables.removeLast();
		removed.setLoaded(false);
		return removed;
	}

	public Deque<Transportable> getStoredItems() {
		return transportables;
	}
}
