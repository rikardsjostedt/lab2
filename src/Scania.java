import java.awt.*;

public class Scania extends Truck {


	public Scania(int x, int y) {
		super(x, y, 90);
	}

	public double speedFactor() {
		return getMaxSpeed() * 0.01;
	}

	@Override
	public int getCurrentSpeed() {
		return 0;
	}
}
