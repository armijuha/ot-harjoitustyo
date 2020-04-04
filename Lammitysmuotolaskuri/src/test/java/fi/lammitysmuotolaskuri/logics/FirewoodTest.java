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
public class FirewoodTest {
    private Firewood f;
    
    public FirewoodTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        f = new Firewood();
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void constuctorSetsPriceCorrectly() {

        assertEquals(80, f.getPrice(), 0.0001);
    }
    
    @Test
    public void constuctorSetsEfficiencyCorrectly() {

        assertEquals(0.8, f.getEfficiency(), 0.0001);
    }
    
    @Test
    public void constuctorSetsEnergyContentCorrectly() {

        assertEquals(1010, f.getEnergyContent(), 0.0001);
    }
    
    @Test
    public void energyPriceCountedCorrectly() {
        f.setPrice(100);
        f.setEfficiency(0.5);
        f.setEnergyContent(1000);

        assertEquals(0.2, f.countEnergyPrice(), 0.0001);
    }
    
}
