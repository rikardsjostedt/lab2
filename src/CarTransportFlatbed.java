import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransportFlatbed extends Flatbed implements Loadable<Car> {

	private Deque<Car> cars = new ArrayDeque<>();
	private int capacity;

	public CarTransportFlatbed(CarTransport truck, int capacity, double width, double length) {
		super(truck, width, length);
		this.capacity = capacity;
	}

	public void up() {
		tilt(getMaxTilt());
	}

	public void down() {
		if (getTruck().getCurrentSpeed() == 0)
			tilt(getMinTilt());
	}

	@Override
	public void load(Car car) {
		if (cars.size() < capacity && getCurrentTilt() == 0 && car.getDirection() == getTruck().getDirection()) {
			car.startEngine();
			car.gas(5);
			while (car.getX() != getTruck().getX() && car.getY() != getTruck().getY()) {
				car.move(car.getDirection());
			}
		}
	}

	@Override
	public Car unload(Car car) {
		try {
			car.startEngine();
			car.reverse(car.getDirection());
			return cars.pop();
		} catch (Exception e) {
			System.out.println("No cars on flatbed");
			return null;
		}
	}
}
