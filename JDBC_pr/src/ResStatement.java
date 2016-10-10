import java.sql.*;


/**
 * 
 * @author Sebas
 *	
 *	TOFOPlease make ONE query selecting multiple data
 *
 *
 */

public class ResStatement {
	static Connection conn = Connect.connection();;

	public static ResultSet result(){
		ResultSet res = null;
		try{
		String query = "SELECT email FROM USERS WHERE type = 'admin'";
		PreparedStatement stmt = conn.prepareStatement(query);
		res = stmt.executeQuery(query);
		res.next();	
		}catch(SQLException ex){
			
		}
		
		return res;	
	}
	
	public static ResultSet user(){
		ResultSet usrName = null;
		try{
		String query = "SELECT username FROM USERS WHERE type = 'admin'";
		PreparedStatement stmt = conn.prepareStatement(query);
		usrName = stmt.executeQuery(query);
		usrName.next();	
		}catch(SQLException ex){
		}
		return usrName;
	
	}

}
