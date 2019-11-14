import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testGas
{
    private Car car;

    @Before
    public void init() {
        car = new Volvo240();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, false}, { 1, 0.5, true}, { 2, 1, true }, { 3, 0, false}, { 4, 0.3, true }, { 5, 5, false }, { 6, 8, false}, {3, 0.6, true}
        });
    }

    @Parameterized.Parameter(0)
    public double speed;
    @Parameterized.Parameter(1)
    public double gas;
    @Parameterized.Parameter(2)
    public boolean didGas;

    @Test
    public void testGasSpeedShouldIncrease() {
        car.setCurrentSpeed(speed);
        car.gas(gas);
        assertTrue(car.getCurrentSpeed() >= speed);
    }

    @Test
    public void testGasInterval() {
        car.setCurrentSpeed(speed);
        car.gas(gas);
        assertEquals(didGas, car.getCurrentSpeed() != speed);
    }
}
