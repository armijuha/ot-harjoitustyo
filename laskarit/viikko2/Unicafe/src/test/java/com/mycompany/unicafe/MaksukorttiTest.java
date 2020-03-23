package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(990);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(150);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaTrue() {
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalse() {
        assertFalse(kortti.otaRahaa(15));
    }

}
