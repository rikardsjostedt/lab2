import java.util.List;

public interface Storage<T> {

	void load(T t);

	T unload();

	List<T> getStoredItems();

}
