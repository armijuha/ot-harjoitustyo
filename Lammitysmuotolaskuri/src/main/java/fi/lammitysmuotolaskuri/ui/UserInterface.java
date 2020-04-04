package fi.lammitysmuotolaskuri.ui;

import java.util.Scanner;
import fi.lammitysmuotolaskuri.logics.AirHeatPump;
import fi.lammitysmuotolaskuri.logics.ElectricHeating;
import fi.lammitysmuotolaskuri.logics.Firewood;
import fi.lammitysmuotolaskuri.logics.Oil;

public class UserInterface {

    private Scanner scanner;
    private ElectricHeating electric;
    private Firewood wood;
    private Oil oil;
    private AirHeatPump pump;

    public UserInterface(Scanner scanner, ElectricHeating e, Firewood f, Oil o, AirHeatPump p) {
        this.scanner = scanner;
        this.electric = e;
        this.wood = f;
        this.oil = o;
        this.pump = p;

    }

    public void start() {

        printGuide();

        while (true) {
            System.out.println("");
            System.out.print("Valitse toiminto: ");
            String selection = scanner.nextLine();

            if (selection.equals("1")) {
                System.out.print("Anna uusi halkojen hinta (euroa per heittokuutio): ");
                double price = Double.parseDouble(scanner.nextLine());
                wood.setPrice(price);
            } else if (selection.equals("2")) {
                System.out.print("Anna uusi sähköenergian hinta (euroa per kWh): ");
                double price = Double.parseDouble(scanner.nextLine());
                electric.setPrice(price);
            } else if (selection.equals("3")) {
                System.out.print("Anna uusi öljyn hinta (euroa per litra): ");
                double price = Double.parseDouble(scanner.nextLine());
                oil.setPrice(price);
            } else if (selection.equals("4")) {
                System.out.print("Anna pumpun uusi hyötysuhde: ");
                double efficiency = Double.parseDouble(scanner.nextLine());
                pump.setEfficiency(efficiency);
            } else if (selection.equals("5")) {
                printPrices();
            } else if (selection.equals("6")) {
                printGuide();
            } else if (selection.equals("x")) {
                break;
            } else {
                System.out.println("Toimintoa ei löydy, yritä uudelleen");
            }
        }
        System.out.println("Kiitos käynnistä, tervetuloa uudestaan!");
    }

    public void printGuide() {

        System.out.println("");
        System.out.println("Muuta polttopuun hintaa painamalla 1");
        System.out.println("Muuta sähköenergian hintaa painamalla 2");
        System.out.println("Muuta öljyn hintaa painamalla 3");
        System.out.println("Muuta ilmalämpöpumpun hyötysuhdetta painamalla 4");
        System.out.println("Näytä lämmitysmuotojen hinnat painamalla 5");
        System.out.println("Tulosta ohjeet näytölle painamalla 6");
        System.out.println("Lopeta painamalla x");
    }

    public void printPrices() {

        System.out.println("kWh-hinta polttopuulla: " + wood.countEnergyPrice() + " senttiä");
        System.out.println("kWh-hinta sähköllä: " + electric.countEnergyPrice() + " senttiä");
        System.out.println("kWh-hinta öljyllä: " + oil.countEnergyPrice() + " senttiä");
        System.out.println("kWh-hinta ilmalämpöpumpulla: " + pump.countEnergyPrice() + " senttiä");
    }
}
