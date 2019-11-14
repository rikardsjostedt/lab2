import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testGas
{
    private Car car;

    @Before
    public void init()
    {
        car = new Volvo240();
        car.startEngine();
    }

    @Test
    public void testGasInterval()
    {
        double speed = car.getCurrentSpeed();
        car.gas(1.5);
        Assert.assertEquals(speed, car.getCurrentSpeed(), 0.0);
    }
}
