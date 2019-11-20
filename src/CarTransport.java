import java.awt.*;

public class CarTransport extends Truck {


	public CarTransport(Color color, double enginePower, String modelName, double width, double length) {
		super(color, enginePower, modelName, width, length);
	}

	@Override
	protected double speedFactor() {
		return 100;
	}
}
