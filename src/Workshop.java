import java.util.ArrayList;

public class Workshop<T extends Car> {

	private ArrayList<T> carsInWorkshop = new ArrayList<>();

	public void dropOffCar(T car) {
		if (!carsInWorkshop.contains(car))
			carsInWorkshop.add(car);
	}

	public T pickUpCar(T car) {
		if (carsInWorkshop.contains(car)) {
			carsInWorkshop.remove(car);
			return car;
		}
		System.out.println("Car was not in workshop");
		return null;
	}


}
