import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class Cartests {

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
		double startSpeed = speed;
		Car car = new Volvo240();
		car.setCurrentSpeed(startSpeed);
		car.brake(brake);
		assertTrue(car.getCurrentSpeed() <= startSpeed);
	}

}