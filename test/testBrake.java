import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testBrake {

    private Car car;
    @Before
    public void init() {
        car = new Volvo240();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 0.5 }, { 2, 1 }, { 3, 0 }, { 4, 0.3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Parameterized.Parameter
    public double speed;
    @Parameterized.Parameter(1)
    public double brake;

    @Test
    public void testBrakeSpeedShouldNotIncrease() {
        car.setCurrentSpeed(speed);
        car.brake(brake);
        assertTrue(car.getCurrentSpeed() <= speed);
    }

    @Test
    public void testBrakeInterval() {
        car.setCurrentSpeed(speed);
        car.brake(brake);
        if (brake > 1 || brake < 0) {
            assertTrue(car.getCurrentSpeed() == speed);
        } else {
            assertTrue(car.getCurrentSpeed() <= speed);
        }
    }

}
