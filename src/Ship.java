import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * Represents a ship
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public class Ship extends Vehicle implements Transporter<Transportable> {

	private List<Transportable> transportables = new ArrayList<>();
	private final double speedFactor;

	/**
	 * Constructor for the ship, sets initial values and calls super
	 * @param x the x attribute
	 * @param y the y attribute
	 * @see Vehicle
	 */
	public Ship(int x, int y) {
		super(Color.WHITE, 146, 50, "BåtN", x, y);
		speedFactor = 1.2;
	}

	/**
	 * Updates the position of the cargo in store
	 */
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
		super.gas(amount);
		updateCargoPosition();
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 *
	 * @param amount the amount to decrease speed with
	 */
	public void brake(double amount) {
		super.gas(amount);
		updateCargoPosition();
	}

	/**
	 * Loads the ship's cargo with a transportable entity
	 *
	 * @param transportable the entity for the ship to transport
	 */
	public void load(Transportable transportable) {
		if(!transportable.isLoaded()) {
			transportables.add(transportable);
			transportable.setLoaded(true);
		}
	}

	/**
	 * Unloads one entity from the ship's cargo
	 *
	 * @return the unloaded entity
	 */
	public Transportable unload() {
		Transportable unloaded = transportables.remove(0);
		unloaded.setLoaded(false);
		return unloaded;
	}

	/**
	 * @return the stored items
	 */
	public Collection<Transportable> getStoredItems() {
		return transportables;
	}

	@Override
	public double speedFactor() {
		return getMaxSpeed() * 0.01;
	}
}