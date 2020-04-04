
package fi.lammitysmuotolaskuri.logics;

import fi.lammitysmuotolaskuri.logics.ElectricHeating;
import fi.lammitysmuotolaskuri.logics.Firewood;
import fi.lammitysmuotolaskuri.logics.Oil;
import fi.lammitysmuotolaskuri.logics.AirHeatPump;
import fi.lammitysmuotolaskuri.ui.UserInterface;
import java.util.Scanner;


public class Main {
    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Firewood f = new Firewood();
        ElectricHeating e = new ElectricHeating();
        Oil o = new Oil();
        AirHeatPump p = new AirHeatPump();
        
        UserInterface ui = new UserInterface(scanner, e, f, o, p);
        ui.start();
        
    }
        

   
}
