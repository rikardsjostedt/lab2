public interface Transporter<T> extends IStorage<Transportable> {

	void updateCargoPosition();

	double getX();

	double getY();

}