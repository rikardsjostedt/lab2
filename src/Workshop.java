import java.util.ArrayList;

public class Workshop<T extends Car> implements Loadable<T> {

	private ArrayList<T> carsInWorkshop = new ArrayList<>();

	@Override
	public void load(T car) {
		if (!carsInWorkshop.contains(car))
			carsInWorkshop.add(car);
	}

	@Override
	public T unload(T car) {
		if (carsInWorkshop.contains(car)) {
			carsInWorkshop.remove(car);
			return car;
		}
		System.out.println("Car was not in workshop");
		return null;
	}
}
