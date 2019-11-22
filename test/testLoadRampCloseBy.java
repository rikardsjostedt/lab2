import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testLoadRampCloseBy {

    private CarTransport ct;
    private static int ctX = 0;
    private static int ctY = 0;

    @Before
    public void init() {
        ct = new CarTransport(ctX, ctY);
        ct.getRamp().down();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Volvo240(ctX, ctY), true}, {new Saab95(ctX, ctY), true}, {new Volvo240(ctX + 5, ctY), false}, {new Saab95(ctX, ctY +10), false}, {new Saab95(ctX + 10, ctY +10), false}
        });
    }

    @Parameterized.Parameter
    public Transportable car;
    @Parameterized.Parameter(1)
    public boolean isCloseby;

    @Test
    public void testIfTransportableIsCloseBy() {
        ct.getRamp().load(car);
        assertTrue(car.isLoaded() == isCloseby);
    }

}
