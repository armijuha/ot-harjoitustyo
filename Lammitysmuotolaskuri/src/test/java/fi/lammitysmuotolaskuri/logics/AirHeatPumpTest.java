package fi.lammitysmuotolaskuri.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AirHeatPumpTest {

    private AirHeatPump p;
    private ElectricHeating e;

    public AirHeatPumpTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new AirHeatPump();
        e = new ElectricHeating();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void faultyEfficiencyNotSet() {
        p.setEfficiency(0);
        assertEquals(3, p.getEfficiency(), 0.0001);
    }

    @Test
    public void constuctorSetsEfficiencyCorrectly() {
        assertEquals(3, p.getEfficiency(), 0.0001);
    }

    @Test
    public void energyPriceCountedCorrectly() {
        p.setEfficiency(2);
        assertEquals(0.075, p.countEnergyPrice(0.15), 0.0001);
    }

}
