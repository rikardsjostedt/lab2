import java.util.Collection;

public interface IStorage<T> {

	void load(T t);

	T unload();

	Collection<T> getStoredItems();

}
