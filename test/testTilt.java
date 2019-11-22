import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class testTilt {

    private Scania ct;
    private static int ctX = 0;
    private static int ctY = 0;

    @Before
    public void init() {
        ct = new Scania(ctX, ctY);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, true}, {10, true}, {80, false}, {24, true}, {700, false }, {71, false }, {70, true}
        });
    }
    @Parameterized.Parameter(0)
    public int tilt;
    @Parameterized.Parameter(1)
    public boolean didTilt;


    @Test
    public void testTilt() {
        ct.getFlatbed().changeTilt(tilt);
        assertEquals(didTilt, ct.getFlatbed().getCurrentTilt() == tilt );
    }

}
