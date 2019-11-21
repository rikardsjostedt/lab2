import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TwoModeRamp extends Ramp implements Transporter {

    Deque<Transportable> transportables = new ArrayDeque<>();

	public TwoModeRamp(int openAngle) {
	    super(openAngle);
	}

	public void open() {
		if (speedOfAttachedTransporter() == 0) {
			setCurrentAngle(getOpenAngle());
		}
	}

	public void close() {
		setCurrentAngle(getClosedAngle());
	}

    @Override
    public void updateCargoPosition() {
        for (Transportable t : transportables) {

        }
    }

    @Override
    public void load(Transportable transportable) {
		transportables.add(transportable);
    }

    public Transportable unload(Transportable transportable) {
        return transportables.pop();
    }

    @Override
    public Transportable unload() {
        return null;
    }

    @Override
    public List<Transportable> getStoredItems() {
        return null;
    }
}
