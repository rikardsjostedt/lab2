import java.awt.*;

public abstract class Truck implements Movable {

	private Flatbed flatbed;

	private double currentSpeed;

	public Truck() {
		this.flatbed = new Flatbed(this);
	}

	public boolean hasFlatbed() {
		return this.flatbed != null;
	}

	@Override
	public void move(Direction direction) {
		if (this.flatbed.getCurrentTilt() != 0)
			return;
	}

	@Override
	public void turnLeft() {

	}

	@Override
	public void turnRight() {

	}
}
