import java.sql.*;
import java.util.ArrayList;


/**
 * 
 * @author Sebas
 *	
 *	TOFOPlease make ONE query selecting multiple data
 *
 *
 */

public class QueryHandler {
	static Connection conn = SQL_Handler.connection();;

	public static ResultSet getAdmin(){
		System.out.println("inne i admin");
		ResultSet res = null;
		try{
		String query = "SELECT username,email,password FROM USERS WHERE type = 'admin'";
		PreparedStatement stmt = conn.prepareStatement(query);
		res = stmt.executeQuery(query);
		res.next();	
		}catch(SQLException ex){
			
		}
		System.out.println("snart ute i admin");
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
	
	public static ResultSet owner(){
		ResultSet usrName = null;
		try{
		String query = "SELECT username,email,status FROM USERS WHERE type = 'owner'";
		PreparedStatement stmt = conn.prepareStatement(query);
		usrName = stmt.executeQuery(query);
		usrName.next();	
		}catch(SQLException ex){
		}
		return usrName;
	
	}
	
	 public static ArrayList<ArrayList<Object>> getOwners() {

	        ArrayList<ArrayList <Object>> result = new ArrayList<>();


	    

	        try {
	        	ResultSet rs = null;
				String query2 = "SELECT username,email,status FROM USERS WHERE type = 'owner'";
				PreparedStatement stmt = conn.prepareStatement(query2);
	            rs = stmt.executeQuery(query2);


	            ResultSetMetaData metaData = rs.getMetaData();

	            //Loops through each returned row.
	            while(rs.next())
	            {
	                ArrayList<Object> row = new ArrayList<>();

	                // Initialize all indexes we will use in the arraylist.
	                for(int i = 0; i<=metaData.getColumnCount()-1; i++) {
	                    row.add(null);
	                }

	                // Check if the data is an image or not.
	                for(int i = 1; i<=metaData.getColumnCount(); i++)
	                {

	                        row.set(i-1,rs.getObject(i));
	                    
	                }
	                result.add(row);
	            }
	        } catch (SQLException ex) {
	          
	        } 

	        return result;
	    }
	 
	 


}
