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
public class ElectricHeatingTest {

    private ElectricHeating e;

    public ElectricHeatingTest() {
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void faultyPriceNotSet() {
        e.setPrice(-1);
        assertEquals(0.04, e.getPrice(), 0.0001);
    }

    @Test
    public void faultyTransferPriceNotSet() {
        e.setTransferPrice(20);
        assertEquals(0.07, e.getTransferPrice(), 0.0001);
    }

    @Test
    public void constuctorSetsPriceCorrectly() {

        assertEquals(0.04, e.getPrice(), 0.0001);
    }

    @Test
    public void constuctorSetsTransferPriceCorrectly() {

        assertEquals(0.07, e.getTransferPrice(), 0.0001);
    }

    @Test
    public void energyPriceCountedCorrectly() {
        e.setPrice(0.05);
        e.setTransferPrice(0.1);

        assertEquals(0.15, e.countEnergyPrice(), 0.0001);
    }
}
