public class TiltableRamp extends Ramp
{
    public TiltableRamp(int openAngle)
    {
        super(openAngle);
    }

    public void tilt(int degree) {
        if (speedOfAttachedTransporter() == 0 && degree <= getOpenAngle() && degree >= getClosedAngle()) {
            setCurrentAngle(degree);
        }
    }
}
