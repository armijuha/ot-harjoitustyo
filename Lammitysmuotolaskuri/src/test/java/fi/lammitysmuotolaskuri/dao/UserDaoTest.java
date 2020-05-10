package fi.lammitysmuotolaskuri.dao;

import fi.lammitysmuotolaskuri.logics.AirHeatPump;
import fi.lammitysmuotolaskuri.logics.ElectricHeating;
import fi.lammitysmuotolaskuri.logics.Firewood;
import fi.lammitysmuotolaskuri.logics.Oil;
import fi.lammitysmuotolaskuri.logics.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author armijuha
 */
public class UserDaoTest {

    private User u;
    private ElectricHeating e;
    private Firewood f;
    private Oil o;
    private AirHeatPump p;
    private UserDao dao;

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./testitietokanta", "sa", "");
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Lammitysmuoto");
            stmt.execute();
            stmt.close();
        } catch (Exception exception) {
            conn.prepareStatement("CREATE TABLE Lammitysmuoto (id serial, name varchar(255), electricprice numeric(9,4), electrictransferprice numeric(9,4),"
                    + " woodprice numeric(9,4), woodefficiency numeric(9,4), woodenergycontent numeric(9,4), oilprice numeric(9,4), oilefficiency numeric(9,4),"
                    + " oilenergycontent numeric(9,4), pumpefficiency numeric (9,4));").executeUpdate();
        }
        conn.close();

        e = new ElectricHeating();
        f = new Firewood();
        o = new Oil();
        p = new AirHeatPump();
        String name = "TestUser";
        u = new User(name, e.getPrice(), e.getTransferPrice(), f.getPrice(), f.getEfficiency(), f.getEnergyContent(), o.getPrice(), o.getEfficiency(), o.getEnergyContent(), p.getEfficiency());
        dao = new UserDao();
    }

    @After
    public void tearDown() throws SQLException {
        dao.delete("TestUser");
    }

    @Test
    public void checkGivesFalseIfUserNotExist() throws SQLException {
        assertFalse(dao.check("Reima"));
    }
    
    @Test
    public void checkGivesTrueIfUserExists() throws SQLException {
        dao.create(u);
        assertTrue(dao.check("TestUser"));
    }

    @Test
    public void dataCanBeCreatedAndLoaded() throws SQLException {
        dao.create(u);
        u.setElectricPrice(0.20);
        u = dao.read("TestUser");
        assertEquals(0.04, u.getElectricPrice(), 0.0001);
    }

    @Test
    public void userCanBeDeleted() throws SQLException {
        dao.delete("TestUser");
        assertFalse(dao.check("TestUser"));
    }
}
