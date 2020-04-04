
package fi.lammitysmuotolaskuri.logics;


public class Firewood {
    private double price;
    private double energyContent;
    private double efficiency;

    public Firewood() {
        this.price = 80; //euroa per heittokuutio, koivu
        this.energyContent = 1010; //kWh per heittokuutio, kuiva koivuklapi
        this.efficiency = 0.8; //hyvä varaava takka
    }
    public double countEnergyPrice() {
        double overallPrice = this.price / (this.energyContent * this.efficiency);
        return overallPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
    
    public double getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getEnergyContent() {
        return this.energyContent;
    }

    public void setEnergyContent(double energyContent) {
        this.energyContent = energyContent;
    }
    
    
    
    
    
    
}
