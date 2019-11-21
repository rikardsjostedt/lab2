import java.util.Collection;

public class CarTransport extends Truck implements Movable {

	private Ramp ramp;

	public CarTransport(double x, double y, int maxSpeed) {
		super(x, y, maxSpeed);
		this.ramp = new Ramp(this, 10);
	}

	@Override
	public void gas(double amount) {
		if (!ramp.isDown()) {
			super.gas(amount);
			ramp.updateCargoPosition();
		}
	}

	@Override
	public void brake(double amount) {
		super.brake(amount);
		ramp.updateCargoPosition();
	}
}
