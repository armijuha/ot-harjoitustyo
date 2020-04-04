/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lammitysmuotolaskuri.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author armijuha
 */
public class OilTest {

    private Oil o;

    public OilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        o = new Oil();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constuctorSetsEnergyContentCorrectly() {

        assertEquals(10, o.getEnergyContent(), 0.001);
    }

    @Test
    public void constuctorSetsPriceCorrectly() {

        assertEquals(0.74, o.getPrice(), 0.0001);
    }

    @Test
    public void constuctorSetsEfficiencyCorrectly() {

        assertEquals(0.9, o.getEfficiency(), 0.0001);
    }

    @Test
    public void energyPriceCountedCorrectly() {
        o.setEfficiency(1);
        o.setPrice(1);
        o.setEnergyContent(10);
        
        assertEquals(0.1, o.countEnergyPrice(), 0.0001);
    }
}
