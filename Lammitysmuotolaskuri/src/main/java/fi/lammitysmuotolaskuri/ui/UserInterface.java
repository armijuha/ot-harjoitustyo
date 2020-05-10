/**
 * Käyttöliittymä.
 */
package fi.lammitysmuotolaskuri.ui;

import java.util.Scanner;
import fi.lammitysmuotolaskuri.logics.AirHeatPump;
import fi.lammitysmuotolaskuri.logics.ElectricHeating;
import fi.lammitysmuotolaskuri.logics.Firewood;
import fi.lammitysmuotolaskuri.logics.Oil;
import fi.lammitysmuotolaskuri.dao.UserDao;
import fi.lammitysmuotolaskuri.logics.User;
import java.sql.SQLException;

import java.text.DecimalFormat;

/**
 * Luokka vastaa sovelluksen käyttöliittymästä.
 */
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

    /**
     * Metodi kysyy käyttäjältä mitä tehdään eli pyytää syötteen ja kutsuu
     * syötettä vastaavaa metodia.
     *
     * @throws java.sql.SQLException
     */
    public void start() throws SQLException {

        System.out.println("*************************************************************************");
        System.out.println("Lämmitysmuotolaskuri - laskee millä lämmität asuntosi edullisimmin tänään");
        System.out.println("*************************************************************************");
        System.out.println("");
        System.out.println("Kaikille hinnoille, hyötysuhteille ja energiasisällöille on annettu oletusarvo.");
        System.out.println("Kuitenkin vain syöttämällä omat ajantasaiset tietosi voidaan laskea juuri sinulle ja tähän hetkeen edullisin lämmitysmuoto.");
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
                if (checkInputType()) {
                    double price = Double.parseDouble(scanner.nextLine());
                    electric.setPrice(price);
                }
            } else if (selection.equals("11")) {
                System.out.print("Anna uusi sähkön siirtohinta (euroa per kWh, sisältäen sähköveron, oletusarvo 0.07): ");
                if (checkInputType()) {
                    double transferPrice = Double.parseDouble(scanner.nextLine());
                    electric.setTransferPrice(transferPrice);
                }
            } else if (selection.equals("20")) {
                System.out.print("Anna uusi halkojen hinta (euroa per heittokuutio, oletusarvo 80): ");
                if (checkInputType()) {
                    double price = Double.parseDouble(scanner.nextLine());
                    wood.setPrice(price);
                }
            } else if (selection.equals("21")) {
                System.out.print("Anna uusi hyötysuhde takalle (oletusarvo 0.80, hyvä varaava takka): ");
                if (checkInputType()) {
                    double efficiency = Double.parseDouble(scanner.nextLine());
                    wood.setEfficiency(efficiency);
                }
            } else if (selection.equals("22")) {
                System.out.print("Anna uusi puun energiasisältö (kWh per heittokuutio, oletusarvo 1010, kuiva koivuklapi): ");
                if (checkInputType()) {
                    double energyContent = Double.parseDouble(scanner.nextLine());
                    wood.setEnergyContent(energyContent);
                }
            } else if (selection.equals("30")) {
                System.out.print("Anna uusi öljyn/polttonesteen hinta (euroa per litra, oletusarvo 0.74): ");
                if (checkInputType()) {
                    double price = Double.parseDouble(scanner.nextLine());
                    oil.setPrice(price);
                }
            } else if (selection.equals("31")) {
                System.out.print("Anna uusi öljyn/polttonesteen polttamisen hyötysuhde (oletusarvo 0.90): ");
                if (checkInputType()) {
                    double efficiency = Double.parseDouble(scanner.nextLine());
                    oil.setEfficiency(efficiency);
                }
            } else if (selection.equals("32")) {
                System.out.print("Anna uusi öljyn/polttonesteen energiasisältö (kWh per litra, oletusarvo 10): ");
                if (checkInputType()) {
                    double energyContent = Double.parseDouble(scanner.nextLine());
                    oil.setEnergyContent(energyContent);
                }
            } else if (selection.equals("40")) {
                System.out.print("Anna pumpun uusi hyötysuhde: ");
                if (checkInputType()) {
                    double efficiency = Double.parseDouble(scanner.nextLine());
                    pump.setEfficiency(efficiency);
                }
            } else if (selection.equals("1")) {
                printPrices();
            } else if (selection.equals("2")) {
                printGuide();
            } else if (selection.equals("3")) {
                saveData();
            } else if (selection.equals("4")) {
                updateData();
            } else if (selection.equals("5")) {
                loadData();
            } else if (selection.equals("6")) {
                deleteUserData();
            } else {
                System.out.println("Toimintoa ei löydy, yritä uudelleen");
            }
        }
        System.out.println("Kiitos käynnistä, tervetuloa uudestaan!");
    }

    /**
     * Tulostaa ruudulle ohjeen joka kertoo komennot.
     */
    public void printGuide() {

        System.out.println("");
        System.out.println("Valitse toiminto syöttämällä jokin seuraavista komennoista: ");
        System.out.println("1 Näytä lämmitysmuotojen hinnat senttiä/kWh");
        System.out.println("2 Tulosta ohjeet näytölle");
        System.out.println("3 Tee uusi käyttäjänimi jolle tallennetaan muuttamasi hintatiedot");
        System.out.println("4 Tallenna muuttamasi hintatiedot olemassa olevalle käyttäjänimellesi");
        System.out.println("5 Lataa tallennetut hintatietosi käyttäjänimesi avulla");
        System.out.println("6 Poista käyttäjänimesi tiedot");
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

    /**
     * Metodi kertoo onko käyttäjän syöte oikeaa tyyppiä (double).
     *
     * @return true jos syöte on double tyyppiä
     */
    public boolean checkInputType() {
        if (scanner.hasNextDouble()) {
            return true;
        } else {
            System.out.println("Virheellinen syöte, tarvitaan desimaaliluku (käytä desimaalierottimena pistettä)");
        }
        String cleaningAway = scanner.nextLine();
        return false;
    }

    /**
     * Tulostaa ruudulle lämmitysmuotojen hinnat per kWh.
     */
    public void printPrices() {
        DecimalFormat df = new DecimalFormat("#.####");
        Double ePrice = electric.countEnergyPrice();
        System.out.println("");
        System.out.println("Lämmitysenergian hinnat ovat seuraavat.");
        System.out.println("Polttopuulla: " + df.format(wood.countEnergyPrice()) + " senttiä per kWh");
        System.out.println("Sähköllä: " + df.format(ePrice) + " senttiä per kWh");
        System.out.println("Öljyllä: " + df.format(oil.countEnergyPrice()) + " senttiä per kwh");
        System.out.println("Ilmalämpöpumpulla: " + df.format(pump.countEnergyPrice(ePrice)) + " senttiä per kWh");
        System.out.println("Edullisin lämmitysmuoto tällä hetkellä on: " + countCheapest() + "!");
    }

    /**
     *
     * Metodi vertailee mikä on halvin lämmitysmuoto
     *
     * @return palauttaa halvimman lämmitysmuodon
     */
    public String countCheapest() {
        double e = electric.countEnergyPrice();
        double w = wood.countEnergyPrice();
        double o = oil.countEnergyPrice();
        double p = pump.countEnergyPrice(e);

        if (p < e && p < w && p < o) {
            return "ILMALÄMPÖPUMPPU";
        } else if (e < w && e < o) {
            return "SÄHKÖ";
        } else if (w < o) {
            return "POLTTOPUU";
        } else {
            return "ÖLJY";
        }
    }

    /**
     * Tallentaa käyttäjän nimen ja hintatiedot pysyväismuistiin tietokantaan.
     *
     * @throws SQLException
     */
    public void saveData() throws SQLException {
        System.out.println("Anna käyttäjänimi jolla hintatietosi tallennetaan: ");
        String name = scanner.nextLine();
        if (name.isEmpty() || name.length() > 100) {
            System.out.println("Valitse käyttäjänimi jossa on 1-100 merkkiä, kiitos.");
            return;
        }
        if (!dao.check(name)) {
            User user = new User(name, electric.getPrice(), electric.getTransferPrice(), wood.getPrice(), wood.getEfficiency(), wood.getEnergyContent(), oil.getPrice(), oil.getEfficiency(), oil.getEnergyContent(), pump.getEfficiency());
            dao.create(user);
            System.out.println("Kiitos " + name + ", hintatietosi on nyt tallennettu.");
        } else {
            System.out.println("Käyttäjänimi " + name + " on jo käytössä. Valitse toinen käyttäjänimi kiitos!");
        }

    }

    /**
     * Päivittää vanhalle käyttäjänimelle uudet hintatiedot pysyväismuistiin
     *
     * @throws SQLException
     */
    public void updateData() throws SQLException {
        System.out.println("Anna käyttäjänimi jolle hintatietosi päivitetään: ");
        String name = scanner.nextLine();

        if (dao.check(name)) {
            User user = new User(name, electric.getPrice(), electric.getTransferPrice(), wood.getPrice(), wood.getEfficiency(), wood.getEnergyContent(), oil.getPrice(), oil.getEfficiency(), oil.getEnergyContent(), pump.getEfficiency());
            dao.update(user);
            System.out.println("Kiitos " + name + ", hintatietosi on nyt päivitetty.");
        } else {
            System.out.println("Käyttäjänimeä " + name + " ei löytynyt. Valitse toinen käyttäjänimi kiitos!");
        }

    }

    /**
     * Poistaa käyttäjän ja tämän tiedot pysyväismuistista.
     *
     * @throws SQLException
     */
    public void deleteUserData() throws SQLException {
        System.out.println("Anna käyttäjänimi jonka haluat poistaa: ");
        String name = scanner.nextLine();

        if (dao.check(name)) {
            dao.delete(name);
            System.out.println("Kiitos " + name + ",tietosi on nyt poistettu.");
        } else {
            System.out.println("Käyttäjänimeä " + name + " ei löytynyt. Valitse toinen käyttäjänimi kiitos!");
        }

    }

    /**
     * Lataa käyttäjän hintatiedot pysyväismuistista tietokannasta.
     *
     * @throws SQLException
     */
    public void loadData() throws SQLException {
        System.out.println("Anna käyttäjänimi jolla hintatietosi on tallennettu: ");
        String name = scanner.nextLine();
        if (dao.check(name)) {
            User user = dao.read(name);
            System.out.println("Kiitos " + name + ", hintatietosi on nyt haettu.");
            electric.setPrice(user.getElectricPrice());
            electric.setTransferPrice(user.getElectricTransferPrice());
            wood.setPrice(user.getWoodPrice());
            wood.setEfficiency(user.getWoodEfficiency());
            wood.setEnergyContent(user.getWoodEnergyContent());
            oil.setPrice(user.getOilPrice());
            oil.setEfficiency(user.getOilEfficiency());
            oil.setEnergyContent(user.getOilEnergyContent());
            pump.setEfficiency(user.getPumpEfficiency());
            printPrices();
        } else {
            System.out.println("Käyttäjänimeä ei löytynyt, tarkista käyttäjänimi ja yritä uudelleen, kiitos.");
        }
    }
}
