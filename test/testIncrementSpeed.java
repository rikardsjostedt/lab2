import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testIncrementSpeed
{
    private Car car;
    @Before
    public void init()
    {
        car = new Saab95();
        car.startEngine();
    }

    @Test
    public void testIncreaseSpeed()
    {
        double speed = car.getCurrentSpeed();
        car.gas(0.1);

        Assert.assertTrue(speed < car.getCurrentSpeed());
    }
}
