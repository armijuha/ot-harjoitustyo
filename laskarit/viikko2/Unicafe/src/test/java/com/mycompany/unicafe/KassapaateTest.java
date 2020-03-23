/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void rahamaaraOikein() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void lounasmaaraOikein() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty() + paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassaKasvaaMaukkaalla() {
        paate.syoMaukkaasti(400);
        assertEquals(100400, paate.kassassaRahaa());
    }

    @Test
    public void kassaKasvaaEdullisella() {
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());
    }

    @Test
    public void vaihtorahaMaukkaalla() {
        assertEquals(100, paate.syoMaukkaasti(500));
    }

    @Test
    public void vaihtorahaEdullisella() {
        assertEquals(260, paate.syoEdullisesti(500));
    }

    @Test
    public void lounasmaaraKasvaaMaukkaalla() {
        paate.syoMaukkaasti(400);
        paate.syoMaukkaasti(400);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void lounasmaaraKasvaaEdukkaalla() {
        paate.syoEdullisesti(240);
        paate.syoEdullisesti(240);
        assertEquals(2, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassaEiMuutuLiianVahallaRahallaEdullisella() {
        paate.syoEdullisesti(200);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kassaEiMuutuLiianVahallaRahallaMaukkaalla() {
        paate.syoMaukkaasti(300);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void lounasmaaraEiMuutuLiianVahallaRahallaEdullisella() {
        paate.syoEdullisesti(200);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void lounasmaaraEiMuutuLiianVahallaRahallaMaukkaalla() {
        paate.syoMaukkaasti(300);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void vaihtorahaPalautuuLiianVahallaRahallaEdullisella() {
        assertEquals(200, paate.syoEdullisesti(200));
    }

    @Test
    public void vaihtorahaPalautuuLiianVahallaRahallaMaukkaalla() {
        assertEquals(300, paate.syoMaukkaasti(300));
    }

    @Test
    public void maukasSummaVeloitetaanKortilta() {
        paate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void edullinenSummaVeloitetaanKortilta() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void maukasSummaKortiltaPalauttaaTrue() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void edullinenSummaKortiltaPalauttaaTrue() {
        assertTrue(paate.syoEdullisesti(kortti));
    }

    @Test
    public void maukasKortiltaLisaaLounaidenMaaraa() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullinenKortiltaLisaaLounaidenMaaraa() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(2, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukasSummaEiVeloituLiianTyhjaltaKortilta() {
        kortti.otaRahaa(900);
        paate.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void edullinenSummaEiVeloituLiianTyhjaltaKortilta() {
        kortti.otaRahaa(900);
        paate.syoEdullisesti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void maukasLiianTyhjaltaKortiltaEiLisaaLounaidenMaaraa() {
        kortti.otaRahaa(800);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullinenLiianTyhjaltaKortiltaEiLisaaLounaidenMaaraa() {
        kortti.otaRahaa(800);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukasLiianTyhjaltaKortiltaPalauttaaFalse() {
        kortti.otaRahaa(800);
        assertFalse(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void edullinenLiianTyhjaltaKortiltaPalauttaaFalse() {
        kortti.otaRahaa(800);
        assertFalse(paate.syoEdullisesti(kortti));
    }

    @Test
    public void kassaEiMuutuKortillaMaukas() {
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kassaEiMuutuKortillaEdullinen() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kortinSaldoMuuttuuLadattaessa() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }

    @Test
    public void kassaKasvaaLadattaessa() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, paate.kassassaRahaa());
    }

    @Test
    public void negatiivinenLatausEiMuutaKassaa() {
        paate.lataaRahaaKortille(kortti, -200);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void negatiivinenLatausEiMuutaKortinSaldoa() {
        paate.lataaRahaaKortille(kortti, -200);
        assertEquals(1000, kortti.saldo());
    }

}
