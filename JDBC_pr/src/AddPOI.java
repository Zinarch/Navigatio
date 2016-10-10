import java.sql.*;
import java.util.*;

public class AddPOI {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		Connection conn = null;
	    PreparedStatement stmt = null;
		
		String uri = "jdbc:mysql://localhost:3306/testdb1";
		final String username = "Sebastian";
		final String password = "ch13875th";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Opening a connection
			System.out.println("Connecting to database.....");
			conn = DriverManager.getConnection(uri, username, password);
			System.out.println("Connected... i think");
			
			//Ask the user for inputs to import into the tables attributes.
			
	        System.out.print("Enter a title: ");
	        String title = userInput.nextLine();

	        System.out.print("Enter POI Description: ");
	        String description = userInput.nextLine();

	        
	        System.out.print("Enter Opening-days: ");
	        String openingDays = userInput.nextLine();
			
			//Executing queries here
		      System.out.println("Creating statement...");
		      String sql = "insert into poi" +  "(Title, Description, Location, Opening-days)" + "values ('?', '?', '?')";
		     stmt = conn.prepareStatement(sql);
		     stmt.setString(1, title);
		     stmt.setString(2, description);
		     stmt.setString(3, openingDays);
		     stmt.executeUpdate(); 
		     
		     System.out.println(" It has been DONE!");
		      
		}catch(SQLException ex){
			System.out.println("Shit is hitting the fan.");
			ex.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		         
		      }
		}
		
		System.out.println("See ya! (hopefully it worked out)");
	}

}
