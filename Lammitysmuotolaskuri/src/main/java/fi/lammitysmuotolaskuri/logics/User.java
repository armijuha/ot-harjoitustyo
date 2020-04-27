/**
 * Sovelluslogiikka.
 */
package fi.lammitysmuotolaskuri.logics;

/**
 * Luokka tarjoaa käyttäjän nimen sekä käyttäjän lämmitysenergian hintoihin liittyvät tiedot.
 */
public class User {

    private String name;
    private double electricPrice;
    private double electricTransferPrice;
    private double woodPrice;
    private double woodEfficiency;
    private double woodEnergyContent;
    private double oilPrice;
    private double oilEfficiency;
    private double oilEnergyContent;
    private double pumpEfficiency;

    public User(String name, double electricPrice, double electricTransferPrice, double woodPrice, double woodEfficiency, double woodEnergyContent, double oilPrice, double oilEfficiency, double oilEnergyContent, double pumpEfficiency) {
        this.name = name;
        this.electricPrice = electricPrice;
        this.electricTransferPrice = electricTransferPrice;
        this.woodPrice = woodPrice;
        this.woodEfficiency = woodEfficiency;
        this.woodEnergyContent = woodEnergyContent;
        this.oilPrice = oilPrice;
        this.oilEfficiency = oilEfficiency;
        this.oilEnergyContent = oilEnergyContent;
        this.pumpEfficiency = pumpEfficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(double electricPrice) {
        this.electricPrice = electricPrice;
    }

    public double getElectricTransferPrice() {
        return electricTransferPrice;
    }

    public void setElectricTransferPrice(double electricTransferPrice) {
        this.electricTransferPrice = electricTransferPrice;
    }

    public double getWoodPrice() {
        return woodPrice;
    }

    public void setWoodPrice(double woodPrice) {
        this.woodPrice = woodPrice;
    }

    public double getWoodEfficiency() {
        return woodEfficiency;
    }

    public void setWoodEfficiency(double woodEfficiency) {
        this.woodEfficiency = woodEfficiency;
    }

    public double getWoodEnergyContent() {
        return woodEnergyContent;
    }

    public void setWoodEnergyContent(double woodEnergyContent) {
        this.woodEnergyContent = woodEnergyContent;
    }

    public double getOilPrice() {
        return oilPrice;
    }

    public void setOilPrice(double oilPrice) {
        this.oilPrice = oilPrice;
    }

    public double getOilEfficiency() {
        return oilEfficiency;
    }

    public void setOilEfficiency(double oilEfficiency) {
        this.oilEfficiency = oilEfficiency;
    }

    public double getOilEnergyContent() {
        return oilEnergyContent;
    }

    public void setOilEnergyContent(double oilEnergyContent) {
        this.oilEnergyContent = oilEnergyContent;
    }

    public double getPumpEfficiency() {
        return pumpEfficiency;
    }

    public void setPumpEfficiency(double pumpEfficiency) {
        this.pumpEfficiency = pumpEfficiency;
    }
    
    

}
