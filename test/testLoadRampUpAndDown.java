import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testLoadRampUpAndDown {

    private CarTransport ct;
    private static double ctX = 0;
    private static double ctY = 0;

    @Before
    public void init() {
        ct = new CarTransport(ctX, ctY);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Volvo240(ctX, ctY)}, {new Saab95(ctX, ctY)}
        });
    }

    @Parameterized.Parameter
    public Transportable car;

    @Test
    public void loadCarTransportRampWithRampDown() {
        ct.getRamp().down();
        ct.getRamp().load(car);
        assertTrue(car.isLoaded());
        ct.getRamp().unload();
    }

    @Test
    public void loadCarTransportRampWithRampUp() {
        ct.getRamp().up();
        ct.getRamp().load(car);
        assertFalse(car.isLoaded());
    }

}
