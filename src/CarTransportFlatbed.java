import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransportFlatbed extends Flatbed implements Loadable<Car> {

	private Deque<Car> cars = new ArrayDeque<>();

	public CarTransportFlatbed(Truck parent) {
		super(parent);
	}



}
