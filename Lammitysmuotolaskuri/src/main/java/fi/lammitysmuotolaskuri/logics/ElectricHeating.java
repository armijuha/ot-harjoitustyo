/**
 * Sovelluslogiikka.
 */
package fi.lammitysmuotolaskuri.logics;

public class ElectricHeating {

    private double price;
    private double transferPrice;
    private double lowerPriceLimit = 0;
    private double higherPriceLimit = 10;
    
    /** 
     * Luokka tarjoaa tietoa sähköenergian ja sähkönsiirron hinnasta
     * sekä lämmitysenergian kokonaishinnasta sähköä käytettäessä.
     */
    public ElectricHeating() {
        this.price = 0.04; //sähköenergian hinta veroineen per kWh;
        this.transferPrice = 0.07; //siirtohinta sis. sähköveron veroineenper kWh;

    }

    /**
     * Metodi laskee energian hinnan.
     * @return lämmitysenergian hinta sähköllä
     */
    public double countEnergyPrice() {
        double overallPrice = this.price + this.transferPrice;
        return overallPrice;
    }

    public void setPrice(double energyPrice) {
        if (energyPrice >= lowerPriceLimit && energyPrice <= higherPriceLimit) {
            this.price = energyPrice;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Hinnan täytyy olla välillä " + lowerPriceLimit + " ... " + higherPriceLimit);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setTransferPrice(double transferPrice) {
        if (transferPrice >= lowerPriceLimit && transferPrice <= higherPriceLimit) {
            this.transferPrice = transferPrice;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Hinnan täytyy olla välillä " + lowerPriceLimit + " ... " + higherPriceLimit);
        }
    }

    public double getTransferPrice() {
        return transferPrice;
    }

}
