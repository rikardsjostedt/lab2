import java.util.Collection;
/**
 * Methods required for classes that uses storage of other items of any type, mostly used for Transportable
 *
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 * @see Transportable
 */
public interface IStorage<T> {
	/**
	 * Loads the storage with an entity.
	 *
	 * @param t the entity to be loaded
	 */
	void load(T t);

	/**
	 * Unloads the storage with an entity
	 *
	 * @return the entity that was removed
	 */
	T unload();

	/**
	 * @return the stored items in the storage
	 */
	Collection<T> getStoredItems();

}
