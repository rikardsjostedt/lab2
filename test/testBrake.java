import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testBrake {

    private Car car;
    @Before
    public void init() {
        car = new Saab95(0, 0);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, false}, {0.5, true}, {1, true }, {0, false}, {0.3, true }, {5, false }, {8, false}
        });
    }

    @Parameterized.Parameter(0)
    public double brake;
    @Parameterized.Parameter(1)
    public boolean didBrake;

    @Test
    public void testBrakeSpeedShouldNotIncrease() {
        car.gas(0.5);
        double prevSpeed = car.getCurrentSpeed();
        car.brake(brake);
        assertTrue(car.getCurrentSpeed() <= prevSpeed);
    }

    @Test
    public void testBrakeInterval() {
        car.gas(0.5);
        double prevSpeed = car.getCurrentSpeed();
        car.brake(brake);
        assertEquals(didBrake, car.getCurrentSpeed() != prevSpeed);
    }

}
