import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class Ramp implements Transporter<Car>{

	private boolean isDown;
	private Truck truck;
	private Deque<Transportable> transportables;
	private int capacity;

	public Ramp(Truck t, int capacity) {
		this.isDown = false;
		this.capacity = capacity;
		this.truck = t;
	}

	public boolean isDown() {
		return isDown;
	}

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

	public void load(Transportable transportable) {
		if(!transportable.isLoaded() && closeby(transportable))
		{
			transportables.addLast(transportable);
			transportable.setLoaded(true);
		}

	}

	private boolean closeby(Transportable t) {
		if(t.getX() == truck.getX() && t.getY() == truck.getY())
			return true;
		return false;
	}

	public Transportable unload() {
		Transportable removed =  transportables.removeLast();
		removed.setLoaded(false);
		return removed;
	}

	public Deque<Transportable> getStoredItems() {
		return transportables;
	}
}
