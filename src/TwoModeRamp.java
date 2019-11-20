public class TwoModeRamp extends Ramp
{
    public TwoModeRamp(int openAngle)
    {
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
}
