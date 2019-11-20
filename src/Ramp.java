public abstract class Ramp {

	private final int closedAngle = 0;
	private int openAngle;
	private int currentAngle;
	private Transporter attachedTo;
	private Storage storage;

	public Ramp(int openAngle) {
		this.currentAngle = 0;
		this.openAngle = openAngle;
	}
	protected double speedOfAttachedTransporter()
	{
		return attachedTo.getCurrentSpeed();
	}

	public void setCurrentAngle(int currentAngle)
	{
		this.currentAngle = currentAngle;
	}

	public int getCurrentAngle()
	{
		return currentAngle;
	}

	public int getOpenAngle()
	{
		return openAngle;
	}

	public int getClosedAngle()
	{
		return closedAngle;
	}
}
