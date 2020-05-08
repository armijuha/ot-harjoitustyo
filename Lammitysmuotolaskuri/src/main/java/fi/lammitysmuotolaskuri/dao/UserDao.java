/**
 * Tietojen pysyväistallennus.
 */
package fi.lammitysmuotolaskuri.dao;

import fi.lammitysmuotolaskuri.logics.User;
import java.sql.*;
import java.util.*;

/**
 * Luokka vastaa tietojen pysyväistallennuksesta tietokantaan ja
 * tietokantahauista.
 */
public class UserDao implements Dao<User, Integer> {

    /**
     * Tekee tietokannan nimeltä Lammitysmuoto jos sitä ei ole vielä olemassa.
     *
     * @throws SQLException
     */
    public UserDao() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Lammitysmuoto");
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            conn.prepareStatement("CREATE TABLE Lammitysmuoto (id serial, name varchar(255), electricprice numeric(9,4), electrictransferprice numeric(9,4),"
                    + " woodprice numeric(9,4), woodefficiency numeric(9,4), woodenergycontent numeric(9,4), oilprice numeric(9,4), oilefficiency numeric(9,4),"
                    + " oilenergycontent numeric(9,4), pumpefficiency numeric (9,4));").executeUpdate();

        }
        conn.close();
    }

    /**
     * Metodi lisää uuden käyttäjän tietokantaan.
     *
     * @param user lisättävä käyttäjä
     * @throws SQLException
     */
    @Override
    public void create(User user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Lammitysmuoto"
                + " (name, electricprice, electrictransferprice, woodprice, woodefficiency, woodenergycontent, oilprice, oilefficiency, oilenergycontent, pumpefficiency)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, user.getName());
        stmt.setDouble(2, user.getElectricPrice());
        stmt.setDouble(3, user.getElectricTransferPrice());
        stmt.setDouble(4, user.getWoodPrice());
        stmt.setDouble(5, user.getWoodEfficiency());
        stmt.setDouble(6, user.getWoodEnergyContent());
        stmt.setDouble(7, user.getOilPrice());
        stmt.setDouble(8, user.getOilEfficiency());
        stmt.setDouble(9, user.getOilEnergyContent());
        stmt.setDouble(10, user.getPumpEfficiency());

        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    /**
     * Metodi tutkii löytyykö käyttäjää tietokannasta
     *
     * @param name haettavan käyttäjän nimi
     * @return true jos käyttäjä löytyy
     * @throws SQLException
     */
    public boolean check(String name) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Lammitysmuoto WHERE name = ?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            stmt.close();
            rs.close();
            conn.close();
            return false;
        }
        stmt.close();
        rs.close();
        conn.close();
        return true;
    }

    /**
     * Metodi lukee käyttäjän tiedot tietokannasta nimen perusteella.
     *
     * @param name haettavan käyttäjän nimi
     * @return käyttäjäolio
     * @throws SQLException
     */
    @Override
    public User read(String name) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Lammitysmuoto WHERE name = ?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }
        User u = new User(rs.getString("name"),
                rs.getDouble("electricprice"),
                rs.getDouble("electrictransferprice"),
                rs.getDouble("woodprice"),
                rs.getDouble("woodefficiency"),
                rs.getDouble("woodenergycontent"),
                rs.getDouble("oilprice"),
                rs.getDouble("oilefficiency"),
                rs.getDouble("oilenergycontent"),
                rs.getDouble("pumpefficiency")
        );

        stmt.close();
        rs.close();
        conn.close();
        return u;
    }

    /**
     * Metodi päivittää uudet tiedot vanhalle käyttäjänimelle, käytännössä vanha
     * käyttäjä poistetaan ja tehdään uusi samalle nimelle.
     *
     * @param user päivitettävä käyttäjä
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        delete(user.getName());
        create(user);
    }

    /**
     * Metodi poistaa käyttäjän tietokannasta.
     *
     * @param name poistettavan käyttäjän nimi
     * @throws SQLException
     */
    @Override
    public void delete(String name) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Lammitysmuoto WHERE name = ?");
        stmt.setString(1, name);
        stmt.executeUpdate();
        stmt.close();
        conn.close();

    }

}
