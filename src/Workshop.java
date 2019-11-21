import java.util.ArrayList;

public class Workshop<T extends Car> implements Storage<Car> {

	private ArrayList<T> carsInWorkshop = new ArrayList<>();

	@Override
	public void load(Car c) {

	}

	@Override
	public Car unload(Car car) {
		if (carsInWorkshop.contains(car)) {
			carsInWorkshop.remove(car);
			return car;
		}
		System.out.println("Car was not in workshop");
		return null;
	}

	@Override
	public Car unload() {
		if (!carsInWorkshop.isEmpty())
			return carsInWorkshop.get(0);
		System.out.println("Workshop empty!");
		return null;
	}

}
