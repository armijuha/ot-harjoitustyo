
package fi.lammitysmuotolaskuri.logics;

public class ElectricHeating {
    private double price;
    private double transferPrice;

    public ElectricHeating() {
        this.price = 0.04; //sähköenergian hinta veroineen per kWh;
        this.transferPrice = 0.07; //siirtohinta sis. sähköveron veroineenper kWh;

    }
    
    public double countEnergyPrice() {
        double overallPrice = this.price + this.transferPrice;
        return overallPrice;
    }

    public void setPrice(double energyPrice) {
        this.price = energyPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setTransferPrice(double transferPrice) {
        this.transferPrice = transferPrice;
    }

    public double getTransferPrice() {
        return transferPrice;
    }
    
    
    
}
