import java.util.Collection;
import java.util.Deque;
import java.util.List;
/**
 * Represents a Ramp with storage connected to a truck
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class Ramp implements Transporter<Car>{

	private boolean isDown;
	private Truck truck;
	private Deque<Transportable> transportables;
	private int capacity;

	/**
	 * Constructor for the Ramp, connects the ramp to a truck and sets initial values.
	 * @param truck the truck to connect the ramp to
	 * @param capacity the capacity of the storage on/of the ramp
	 */
	public Ramp(Truck truck, int capacity) {
		this.isDown = false;
		this.capacity = capacity;
		this.truck = truck;
	}

	/**
	 * @return the isDown attribute
	 */
	public boolean isDown() {
		return isDown;
	}

	/**
	 * Updates the coordinates for the ramp's storage
	 */
	public void updateCargoPosition() {
		for (Transportable t : transportables) {
			t.moveWithTransporter(this);
		}
	}

	/**
	 * @return the x coordinate of the truck the ramp is connected to
	 */
	public double getX() {
		return truck.getX();
	}

	/**
	 * @return the y coordinate of the truck the ramp is connected to
	 */
	public double getY() {
		return truck.getY();
	}

	/**
	 * Loads the storage of the ramp with entities that are 'Transportable' but checks that the entity isn't loaded somewhere else and that it is close to the truck it's getting loaded onto
	 *
	 * @param transportable the entity to be loaded onto the Ramp/Storage of the ramp
	 * @see Transportable
	 */
	public void load(Transportable transportable) {
		if(!transportable.isLoaded() && closeby(transportable) && transportables.size() < capacity)
		{
			transportables.addLast(transportable);
			transportable.setLoaded(true);
			capacity++;
		}
	}

	/**
	 * Checks if the truck the ramp is connected to is close enough to the entity to be loaded
	 *
	 * @param t the entity to be loaded
	 * @return a boolean if the entity is close enough to be loaded
	 */
	private boolean closeby(Transportable t) {
		return t.getX() == truck.getX() && t.getY() == truck.getY();
	}

	/**
	 * Unloads the last entity to be loaded onto the ramp/storage of the ramp
	 *
	 * @return the entity that was unloaded
	 */
	public Transportable unload() {
		Transportable removed =  transportables.removeLast();
		removed.setLoaded(false);
		capacity--;
		return removed;
	}

	/**
	 * @return the stored items on the ramp/storage of the ramp
	 */
	public Deque<Transportable> getStoredItems() {
		return transportables;
	}
}
