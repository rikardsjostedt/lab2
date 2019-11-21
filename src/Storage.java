public interface Storage<T> {

	void load(T t);

	T unload(T t);

	T unload();

}
