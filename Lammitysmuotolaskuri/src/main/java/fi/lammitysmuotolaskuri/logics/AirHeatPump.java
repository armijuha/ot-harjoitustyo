/**
 * Sovelluslogiikka.
 */
package fi.lammitysmuotolaskuri.logics;

public class AirHeatPump {

    private double efficiency;
    private double lowerEfficiencyLimit = 0.1;
    private double higherEfficiencyLimit = 100;
    
    /** 
     * Luokka tarjoaa tietoa ilmalämpöpumpun hyötysuhteesta ja lämmitysenergian hinnasta pumpun avulla.
     */
    public AirHeatPump() {
        this.efficiency = 3;
    }

    /**
     * Metodi laskee energian hinnan.
     * @param electricPrice sähkön kokonaishinta
     * @return lämmitysenergian hinta lämpöpumpulla
     */
    public double countEnergyPrice(double electricPrice) {
        double overallPrice = electricPrice / this.efficiency;
        return overallPrice;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        if (efficiency >= lowerEfficiencyLimit && efficiency <= higherEfficiencyLimit) {
            this.efficiency = efficiency;
        } else {
            System.out.println("Tarkistatko syöttämäsi arvon. Hyötysuhteen täytyy olla välillä " + lowerEfficiencyLimit + " ... " + higherEfficiencyLimit);
        }
    }

}
