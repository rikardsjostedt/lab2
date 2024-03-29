import models.Saab95;
import models.Ship;
import models.Transportable;
import models.Volvo240;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testUpdateCargoPosition {

    private Ship ship;
    private static int ctX = 0;
    private static int ctY = 0;

    @Before
    public void init() {
        ship = new Ship(ctX, ctY);
        ship.load(new Volvo240(ctX, ctY));
        ship.load(new Saab95(ctX, ctY));
    }

    @Test
    public void testUpdateCargoPosition() {
        ship.gas(1);
        for (Transportable ts: ship.getStoredItems()) {
            assertEquals(ship.getX(), ts.getX(), 0.0);
            assertEquals(ship.getY(), ts.getY(), 0.0);
        }
    }
}
