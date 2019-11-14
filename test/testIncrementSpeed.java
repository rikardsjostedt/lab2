import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class testIncrementSpeed {
	private Car car;

	@Before
	public void init() {
		car = new Saab95();
		car.startEngine();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{-1, false}, {1.2, false}, {1, true}, {0, false}, {0.5, true}
		});
	}

	@Parameterized.Parameter
	public double amount;
	@Parameterized.Parameter(1)
	public boolean shouldUpdateSpeed;

	@Test
	public void testIncrementSpeedSaab95() {
		double previousSpeed = car.getCurrentSpeed();
		car.gas(amount);
		Assert.assertEquals(shouldUpdateSpeed, previousSpeed != car.getCurrentSpeed());
	}
}
