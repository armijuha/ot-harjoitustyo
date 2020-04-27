/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lammitysmuotolaskuri.logics;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author armijuha
 */
public class UserTest {

    private User u;
    private ElectricHeating e;
    private Firewood f;
    private Oil o;
    private AirHeatPump p;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        e = new ElectricHeating();
        f = new Firewood();
        o = new Oil();
        p = new AirHeatPump();
        String name = "testUser";
        u = new User(name, e.getPrice(), e.getTransferPrice(), f.getPrice(), f.getEfficiency(), f.getEnergyContent(), o.getPrice(), o.getEfficiency(), o.getEnergyContent(), p.getEfficiency());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constuctorSetsElectricPriceCorrectly() {

        assertEquals(0.04, u.getElectricPrice(), 0.0001);
    }

    @Test
    public void constuctorSetsTransferPriceCorrectly() {

        assertEquals(0.07, u.getElectricTransferPrice(), 0.0001);
    }

    @Test
    public void constuctorSetsOilPriceCorrectly() {

        assertEquals(0.74, u.getOilPrice(), 0.0001);
    }
    
    @Test
    public void constuctorSetsOilEfficiencyCorrectly() {

        assertEquals(0.9, u.getOilEfficiency(), 0.0001);
    }
    
     @Test
    public void constuctorSetsOilEnergyContentCorrectly() {

        assertEquals(10, u.getOilEnergyContent(), 0.0001);
    }
    
    @Test
    public void constuctorSetsFirewoodPriceCorrectly() {

        assertEquals(80, f.getPrice(), 0.0001);
    }
    
    @Test
    public void constuctorSetsFirewoodEfficiencyCorrectly() {

        assertEquals(0.8, f.getEfficiency(), 0.0001);
    }
    
     @Test
    public void constuctorSetsFirewoodEnergyContentCorrectly() {

        assertEquals(1010, f.getEnergyContent(), 0.0001);
    }
    
    @Test
    public void constuctorSetsAirHeatPumpEfficiencyCorrectly() {

        assertEquals(3, p.getEfficiency(), 0.0001);
    }

}
