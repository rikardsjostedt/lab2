import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDecrementSpeed
{
    private Car car;

    @Before
    public void init()
    {
        car = new Volvo240();
        car.startEngine();
    }

    @Test
    public void testDecreaseSpeed()
    {
        car.gas(1);
        double speed = car.getCurrentSpeed();
        car.brake(0.3);

        Assert.assertTrue(speed > car.getCurrentSpeed());
    }

}
