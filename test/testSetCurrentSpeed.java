import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class testSetCurrentSpeed {
	private Car car;
	@Before
	public void init() {
		car = new Volvo240();
		car.startEngine();
	}
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 109, false }, { 23, true }, { 344, false }, { -443, false }, { -5, false }, { 6, true }, { 0, true }
		});
	}


	@Parameterized.Parameter(0)
	public double speed;
	@Parameterized.Parameter(1)
	public boolean shouldUpdateSpeed;

	@Test
	public void testSetCurrentSpeedInterval() {
		double previousSpeed = car.getCurrentSpeed();
		car.setCurrentSpeed(speed);
		Assert.assertEquals(shouldUpdateSpeed, previousSpeed != car.getCurrentSpeed());
	}


}
