public class Flatbed {

	private final int minTilt = 0;
	private final int maxTilt = 70;
	private int currentTilt = 0;
	private Truck parent;

	public Flatbed(Truck parent) {
		this.parent = parent;
	}

	public void rise() {
		if (parent.getCurrentSpeed() != 0 || currentTilt >= maxTilt)
			return;
		//rise flatbed..
	}

	public void lower() {
		if (parent.getCurrentSpeed() != 0 || currentTilt <= maxTilt)
			return;
		//lower flatbed..
	}

	public int getCurrentTilt() {
		return currentTilt;
	}

}
