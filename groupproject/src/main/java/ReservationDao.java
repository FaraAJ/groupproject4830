import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDao {
    private String dburl = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
    private String dbuname = "bnokerremote";
    private String dbpassword = "password";
    private String dbdriver = "com.mysql.jdbc.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public String insertReservation(Reservation reservation) {
        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "Reservation Entered Successfully";

        String sql = "INSERT INTO reservations (name, phone, day, time) VALUES(?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reservation.getName());
            ps.setString(2, reservation.getPhone());
            ps.setString(3, reservation.getDay());
            ps.setString(4, reservation.getTime());

            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Error entering reservation.";
            e.printStackTrace();
        }

        return result;
    }
}
