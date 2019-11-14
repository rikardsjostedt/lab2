import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class testDecrementSpeed {
	private Car car;

	@Before
	public void init() {
		car = new Volvo240();
		car.startEngine();
	}

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, false}, {0, false}, {1, true}
        });
    }

    @Parameterized.Parameter
    public double amount;
    @Parameterized.Parameter(1)
    public boolean shouldUpdateSpeed;

	@Test
	public void testDecrementSpeedSaab95() {
        double previousSpeed = car.getCurrentSpeed();
        car.brake(amount);
        Assert.assertEquals(shouldUpdateSpeed, previousSpeed != car.getCurrentSpeed());
	}

}
