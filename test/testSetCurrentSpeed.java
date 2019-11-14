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
				{ 0, 0, true }, { 1, 0.5, false }, { 2, 1, false }, { 3, 0, false }, { 4, 0.3, false }, { 5, 5, true }, { 6, 8, true }
		});
	}


	@Parameterized.Parameter(0)
	public double speed;
	@Parameterized.Parameter(1)
	public double enginePower;
	@Parameterized.Parameter(2)
	public boolean shouldUpdateSpeed;

	@Test
	public void testSetCurrentSpeedInterval() {
		double previousSpeed = car.getCurrentSpeed();
		car.setEnginePower(enginePower);
		car.setCurrentSpeed(speed);
		Assert.assertEquals(shouldUpdateSpeed, previousSpeed != car.getCurrentSpeed());
	}


}
