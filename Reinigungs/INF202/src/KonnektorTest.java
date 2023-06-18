import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class KonnektorTest {

    private Konnektor konnektor;

    @BeforeEach
    public void setUp() {
        konnektor = new Konnektor();
        konnektor.conn();
    }

    @Test
    public void testConnection() {
        Connection connection = Konnektor.myConn;
        assertNotNull(connection);
        assertTrue(connection instanceof Connection);
    }

    @Test
    public void testStatProdukt() throws SQLException {
        assertNotNull(Konnektor.stat_produkt());
    }

    @Test
    public void testStatKunden() throws SQLException {
        assertNotNull(Konnektor.stat_kunden());
    }

    @Test
    public void testStatLogin() throws SQLException {
        assertNotNull(Konnektor.stat_login());
    }

    @Test
    public void testStatLoginUser() throws SQLException {
        // You can add different scenarios to fully test the stat_loginUser() method.
        // For now, let's just check that it's not null:
        assertNotNull(Konnektor.stat_loginUser());
    }

    // Similar tests can be written for other methods.

    @Test
    public void testStatKundenDelete() throws SQLException {
        // Let's add some data for the test scenario
        String user_TC = "123456789";
        String vorname = "John";
        String nachname = "Doe";
        String email = "john.doe@example.com";
        String tel = "1234567890";

        Statement stmt = Konnektor.myConn.createStatement();
        String insert = "INSERT INTO kunden (`Kunden_TC`, `Vorname`, `Nachname`, `email`, `telefonnummer`) VALUES "
                + "('" + user_TC + "', '" + vorname + "','" + nachname + "','" + email + "','" + tel + "')";

        int x = stmt.executeUpdate(insert);
        assertEquals(1, x);

        assertNotNull(Konnektor.stat_kunden_delete());
    }

    // Similar tests can be written for other methods.

    @Test
    public void testStatRes() throws SQLException {
        assertNotNull(Konnektor.stat_res());
    }

    @Test
    public void testStatKundenEdit() throws SQLException {
        assertNotNull(Konnektor.stat_kunden_edit());
    }

    // Similar tests can be written for other methods.
}
