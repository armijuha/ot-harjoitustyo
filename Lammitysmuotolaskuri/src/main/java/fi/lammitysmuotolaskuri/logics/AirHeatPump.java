
package fi.lammitysmuotolaskuri.logics;


public class AirHeatPump {
    private double efficiency;

    public AirHeatPump() {
        this.efficiency = 3;
    }
    
    public double countEnergyPrice() {
        ElectricHeating e = new ElectricHeating();
        double overallPrice = (e.getPrice() + e.getTransferPrice()) / this.efficiency;
        return overallPrice;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
    
    
}


