
package fi.lammitysmuotolaskuri.logics;


public class AirHeatPump {
    private double efficiency;

    public AirHeatPump() {
        this.efficiency = 3;
    }
    
    public double countEnergyPrice(double electricPrice) {
        double overallPrice = electricPrice / this.efficiency;
        return overallPrice;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
    
    
}


