import java.sql.*;


public class Connect {
	static ResultSet res = null;
	public static Connection connection() {
		Connection conn = null;
		String uri = "jdbc:mysql://leia.skip.chalmers.se:3306/team_03";
		final String username = "team_03";
		final String password = "CVpgphn7i0vvLvoU";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connecting to database.....");
			conn = DriverManager.getConnection(uri, username, password);
			System.out.println("Connected.");
			
		}catch(SQLException ex){
			
		}catch(Exception e){
			
		}
		return conn;
			
			
		}
	}


