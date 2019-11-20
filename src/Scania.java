import java.awt.*;

public class Scania extends Truck {


	public Scania(Color color, double enginePower, String modelName) {
		super(color, enginePower, modelName, 260, 300);
	}

	@Override
	protected double speedFactor() {
		return 0;
	}
}
