import java.sql.*;

public class TestOracleJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:c##testuser/throwaway@localhost");
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM person");
		while(rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.println(rs.getString(2));
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
