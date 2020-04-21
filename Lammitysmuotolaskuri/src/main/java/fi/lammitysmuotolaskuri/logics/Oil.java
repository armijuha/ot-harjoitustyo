package fi.lammitysmuotolaskuri.logics;

public class Oil {

    private double price;
    private double efficiency;
    private double energyContent;

    public Oil() {
        this.price = 0.74; //per litra
        this.efficiency = 0.9;
        this.energyContent = 10; //kWh per litra
    }

    public double countEnergyPrice() {
        double overallPrice = this.price / (this.energyContent * this.efficiency);
        return overallPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setEnergyContent(double energyContent) {
        this.energyContent = energyContent;
    }

    public double getEnergyContent() {
        return energyContent;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getEfficiency() {
        return efficiency;
    }

}
