/**
 * Methods required for vehicles that implements a turbo in the engine system.
 *
 * @author Rikard Sjöstedt
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Turbo {
	/**
	 * Turns on the turbo of the vehicle.
	 */
	public void setTurboOn();

	/**
	 * Turns off the turbo of the vehicle.
	 */
	public void setTurboOff();
}
