public interface Loadable<T extends Transportable> {

	void load(T t);

	T unload();

}
