package fi.lammitysmuotolaskuri.ui;

import java.util.Scanner;
import fi.lammitysmuotolaskuri.logics.AirHeatPump;
import fi.lammitysmuotolaskuri.logics.ElectricHeating;
import fi.lammitysmuotolaskuri.logics.Firewood;
import fi.lammitysmuotolaskuri.logics.Oil;
import fi.lammitysmuotolaskuri.dao.UserDao;
import fi.lammitysmuotolaskuri.logics.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInterface {

    private Scanner scanner;
    private UserDao dao;
    private ElectricHeating electric;
    private Firewood wood;
    private Oil oil;
    private AirHeatPump pump;

    public UserInterface(Scanner scanner, UserDao dao, ElectricHeating e, Firewood f, Oil o, AirHeatPump p) {
        this.scanner = scanner;
        this.dao = dao;
        this.electric = e;
        this.wood = f;
        this.oil = o;
        this.pump = p;

    }

    public void start() throws SQLException {

        System.out.println("*************************************************************************");
        System.out.println("Lämmitysmuotolaskuri - laskee millä lämmität asuntosi edullisimmin tänään");
        System.out.println("*************************************************************************");
        System.out.println("");
        printGuide();

        while (true) {
            System.out.println("");
            System.out.println("Anna komento: ");
            String selection = scanner.nextLine();

            if (selection.equals("x")) {
                break;
            } else if (selection.equals("10")) {
                System.out.print("Anna uusi sähköenergian hinta (euroa per kWh, oletusarvo 0.04): ");
                double price = Double.parseDouble(scanner.nextLine());
                electric.setPrice(price);
            } else if (selection.equals("11")) {
                System.out.print("Anna uusi sähkön siirtohinta (euroa per kWh, sisältäen sähköveron, oletusarvo 0.07): ");
                double transferPrice = Double.parseDouble(scanner.nextLine());
                electric.setTransferPrice(transferPrice);
            } else if (selection.equals("20")) {
                System.out.print("Anna uusi halkojen hinta (euroa per heittokuutio, oletusarvo 80): ");
                double price = Double.parseDouble(scanner.nextLine());
                wood.setPrice(price);
            } else if (selection.equals("21")) {
                System.out.print("Anna uusi hyötysuhde takalle (oletusarvo 0.80, hyvä varaava takka): ");
                double efficiency = Double.parseDouble(scanner.nextLine());
                wood.setEfficiency(efficiency);
            } else if (selection.equals("22")) {
                System.out.print("Anna uusi puun energiasisältö (kWh per heittokuutio, oletusarvo 1010, kuiva koivuklapi): ");
                double energyContent = Double.parseDouble(scanner.nextLine());
                wood.setEnergyContent(energyContent);
            } else if (selection.equals("30")) {
                System.out.print("Anna uusi öljyn/polttonesteen hinta (euroa per litra, oletusarvo 0.74): ");
                double price = Double.parseDouble(scanner.nextLine());
                oil.setPrice(price);
            } else if (selection.equals("31")) {
                System.out.print("Anna uusi öljyn/polttonesteen polttamisen hyötysuhde (oletusarvo 0.90): ");
                double efficiency = Double.parseDouble(scanner.nextLine());
                oil.setEfficiency(efficiency);
            } else if (selection.equals("32")) {
                System.out.print("Anna uusi öljyn/polttonesteen energiasisältö (kWh per litra, oletusarvo 10): ");
                double energyContent = Double.parseDouble(scanner.nextLine());
                oil.setEnergyContent(energyContent);
            } else if (selection.equals("40")) {
                System.out.print("Anna pumpun uusi hyötysuhde: ");
                double efficiency = Double.parseDouble(scanner.nextLine());
                pump.setEfficiency(efficiency);
            } else if (selection.equals("1")) {
                printPrices();
            } else if (selection.equals("2")) {
                printGuide();
            } else if (selection.equals("3")) {
                saveData();
            } else if (selection.equals("4")) {
                loadData();
            } else {
                System.out.println("Toimintoa ei löydy, yritä uudelleen");
            }
        }
        System.out.println("Kiitos käynnistä, tervetuloa uudestaan!");
    }

    public void printGuide() {

        System.out.println("");
        System.out.println("Valitse toiminto syöttämällä jokin seuraavista komennoista: ");
        System.out.println("1 Näytä lämmitysmuotojen hinnat senttiä/kWh");
        System.out.println("2 Tulosta ohjeet näytölle");
        System.out.println("3 Tallenna muuttamasi hintatiedot omalle käyttäjänimellesi");
        System.out.println("4 Lataa tallennetut hintatietosi käyttäjänimesi avulla");
        System.out.println("10 Muuta sähköenergian hintaa");
        System.out.println("11 Muuta sähkön siirtohintaa");
        System.out.println("20 Muuta polttopuun hintaa");
        System.out.println("21 Muuta puun polttamisen hyötysuhdetta");
        System.out.println("22 Muuta puun energiasisältöä");
        System.out.println("30 Muuta öljyn/polttonesteen hintaa");
        System.out.println("31 Muuta öljyn/polttonesteen polttamisen hyötysuhdetta");
        System.out.println("32 Muuta öljyn/polttonesteen energiasisältöä");
        System.out.println("40 Muuta ilmalämpöpumpun hyötysuhdetta");
        System.out.println("x Lopeta ohjelma");
    }

    public void printPrices() {
        
        Double ePrice = electric.countEnergyPrice();
        System.out.println("kWh-hinta polttopuulla: " + wood.countEnergyPrice() + " senttiä");
        System.out.println("kWh-hinta sähköllä: " + ePrice + " senttiä");
        System.out.println("kWh-hinta öljyllä: " + oil.countEnergyPrice() + " senttiä");
        System.out.println("kWh-hinta ilmalämpöpumpulla: " + pump.countEnergyPrice(ePrice) + " senttiä");
    }

    public void saveData() throws SQLException {
        System.out.println("Anna käyttäjänimi jolla hintatietosi tallennetaan: ");
        String name = scanner.nextLine();
        User user = new User(name, electric.getPrice(), electric.getTransferPrice(), wood.getPrice(), wood.getEfficiency(), wood.getEnergyContent(), oil.getPrice(), oil.getEfficiency(), oil.getEnergyContent(), pump.getEfficiency());
        dao.create(user);
        System.out.println("Kiitos " + name + ", hintatietosi on nyt tallennettu.");
    }

    public void loadData() throws SQLException {
        System.out.println("Anna käyttäjänimi jolla hintatietosi on tallennettu: ");
        String name = scanner.nextLine();
        User user = dao.read(name);
        System.out.println("Kiitos " + name + ", hintatietosi on nyt haettu.");
        electric.setPrice(user.getElectricPrice());
        printPrices();
    }
}
