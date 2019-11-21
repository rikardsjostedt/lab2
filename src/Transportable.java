public interface Transportable {


	void moveWithTransporter(Transporter transporter);
	boolean isLoaded();
	void setLoaded(boolean loaded);
	double getX();
	double getY();
}
