import java.awt.*;

public abstract class Truck extends MotorizedVehicle {

	private Flatbed flatbed;
	private final int nrDoors = 2;

	public Truck(Color color, double enginePower, String modelName, double width, double length) {
		super(color, enginePower, modelName, width, length);
		this.flatbed = new Flatbed(this, width, length);
	}

	public boolean hasFlatbed() {
		return this.flatbed != null;
	}

	@Override
	public void move(Direction direction) {
		if (getFlatbed().getCurrentTilt() == getFlatbed().getMinTilt())
			super.move(direction);
	}

	public Flatbed getFlatbed() {
		return flatbed;
	}
}
