import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBrake
{
    private Car car;

    @Before
    public void init()
    {
        car = new Volvo240();
        car.startEngine();
    }

    @Test
    public void testBreakInterval()
    {
        double speed = car.getCurrentSpeed();
        car.gas(-0.5);
        Assert.assertEquals(speed, car.getCurrentSpeed(), 0.0);
    }
}
