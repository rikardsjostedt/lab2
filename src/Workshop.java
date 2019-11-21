import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> implements IStorage<T> {

	private List<T> carsInWorkshop = new ArrayList<>();

	public void load(T t) {
		carsInWorkshop.add(t);
	}

	public T unload() {
		if (!carsInWorkshop.isEmpty())
			return carsInWorkshop.get(0);
		System.out.println("Workshop empty!");
		return null;
	}

	public List<T> getStoredItems() {
		return carsInWorkshop;
	}

}
