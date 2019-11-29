package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a workshop that can store cars
 *
 * @param <T>
 */
public class Workshop<T extends Car> implements IStorage<T> {

	private List<T> carsInWorkshop = new ArrayList<>();

	/**
	 * Loads a car in the workshop
	 *
	 * @param t the entity to be loaded
	 */
	public void load(T t) {
		carsInWorkshop.add(t);
	}

	/**
	 * Unloads the last car stored in the workshop
	 *
	 * @return the car first stored in the workshop
	 */
	public T unload() {
		if (!carsInWorkshop.isEmpty())
			return carsInWorkshop.get(0);
		System.out.println("models.Workshop empty!");
		return null;
	}

	public List<T> getStoredItems() {
		return carsInWorkshop;
	}

}
