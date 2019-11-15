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
                {0, false}, {0.5, true}, {1, true }, {0, false}, {0.3, true }, {5, false }, {8, false}, {.6, true}
        });
    }

    @Parameterized.Parameter(0)
    public double gas;
    @Parameterized.Parameter(1)
    public boolean didGas;

    @Test
    public void testGasSpeedShouldIncrease() {
        car.startEngine();
        double prevSpeed = car.getCurrentSpeed();
        car.gas(gas);
        assertTrue(car.getCurrentSpeed() >= prevSpeed);
    }

    @Test
    public void testGasInterval() {
        car.startEngine();
        double prevSpeed = car.getCurrentSpeed();
        car.gas(gas);
        assertEquals(didGas, car.getCurrentSpeed() != prevSpeed);
    }
}
