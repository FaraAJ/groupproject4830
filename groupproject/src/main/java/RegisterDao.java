import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegisterDao {
	private String dburl = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
	private String dbuname = "bnokerremote";
	private String dbpassword = "password";
	private String dbdriver = "com.mysql.jdbc.Driver";
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public String insert(Member members) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "INSERT INTO users (name, password, phone) VALUES(?,?,?)";
		String result="Data Entered Successfully";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, members.getUname());
			ps.setString(2, members.getPassword());
			ps.setNString(3, members.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="Data Not Entered Successfully";
			e.printStackTrace();
		}
		return result;
	}
}