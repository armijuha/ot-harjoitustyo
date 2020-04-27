/**
 * Sovelluslogiikka.
 */
package fi.lammitysmuotolaskuri.logics;

public class Firewood {

    private double price;
    private double efficiency;
    private double energyContent;
    private double lowerPriceLimit = 0;
    private double higherPriceLimit = 1000;
    private double lowerEfficiencyLimit = 0.01;
    private double higherEfficiencyLimit = 1;
    private double lowerEnergyContentLimit = 1;
    private double higherEnergyContentLimit = 10000;

    /** 
     * Luokka tarjoaa tietoa polttopuun hinnasta, hyötysuhteesta ja energiasisällöstä
     * sekä lämmitysenergian hinnasta puuta poltettaessa.
     */
    public Firewood() {
        this.price = 80; //euroa per heittokuutio, koivu
        this.efficiency = 0.8; //hyvä varaava takka
        this.energyContent = 1010; //kWh per heittokuutio, kuiva koivuklapi
    }

    /**
     * Metodi laskee energian hinnan.
     * @return lämmitysenergian hinta polttopuulla
     */
    public double countEnergyPrice() {
        double overallPrice = this.price / (this.energyContent * this.efficiency);
        return overallPrice;
    }

    public void setPrice(double price) {
        if (price >= lowerPriceLimit && price <= higherPriceLimit) {
            this.price = price;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Hinnan täytyy olla välillä " + lowerPriceLimit + " ... " + higherPriceLimit);
        }

    }

    public double getPrice() {
        return this.price;
    }

    public double getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(double efficiency) {
        if (efficiency >= lowerEfficiencyLimit && efficiency <= higherEfficiencyLimit) {
            this.efficiency = efficiency;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Hyötysuhteen täytyy olla välillä " + lowerEfficiencyLimit + " ... " + higherEfficiencyLimit);
        }
    }

    public double getEnergyContent() {
        return this.energyContent;
    }

    public void setEnergyContent(double energyContent) {
        if (energyContent >= lowerEnergyContentLimit && energyContent <= higherEnergyContentLimit) {
            this.energyContent = energyContent;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Energiasisällön täytyy olla välillä " + lowerEnergyContentLimit + " ... " + higherEnergyContentLimit);
        }

    }
}
