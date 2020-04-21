/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lammitysmuotolaskuri.dao;

import fi.lammitysmuotolaskuri.logics.User;
import java.sql.*;
import java.util.*;

/**
 *
 * @author armijuha
 */
public class UserDao implements Dao<User, Integer> {

    @Override
    public void create(User user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./lammitysmuototietokanta", "sa", "");
        conn.prepareStatement("DROP TABLE Lammitysmuoto IF EXISTS;").executeUpdate();
        conn.prepareStatement("CREATE TABLE Lammitysmuoto (id serial, name varchar(255), electricprice numeric(9,4), electrictransferprice numeric(9,4),"
                + " woodprice numeric(9,4), woodefficiency numeric(9,4), woodenergycontent numeric(9,4), oilprice numeric(9,4), oilefficiency numeric(9,4),"
                + " oilenergycontent numeric(9,4), pumpefficiency numeric (9,4));").executeUpdate();

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

    @Override
    public User update(User object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> list() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
