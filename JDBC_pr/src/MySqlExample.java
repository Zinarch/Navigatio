import java.sql.*;

public class MySqlExample {

	// inserting tuples to an attribute example:  ( INSERT INTO `points of interest` (`Museum`) VALUES ('Museum of Alberta'); ).
		public static void main(String[] args) {
		
			Connection conn = null;
			Statement stmt = null;
			Statement stmt2 = null;
			
			String uri = "jdbc:mysql://localhost:3306/testdb1";
			final String username = "Sebastian";
			final String password = "ch13875th";
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				System.out.println("Connecting to database.....");
				conn = DriverManager.getConnection(uri, username, password);
				System.out.println("Connected... i think");
				
				//Creating test query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      stmt2 = conn.createStatement();
			      String sql;
			      String sqr;
			      sql = "SELECT Type, Published, Status FROM Owner";
			      ResultSet rs = stmt.executeQuery(sql);
			      sqr = "SELECT Museum FROM POI";
			      ResultSet rs2 = stmt2.executeQuery(sqr);
			      System.out.println("Statement created!");
			      while(rs.next()){
			          //Retrieve by column name
			          String Type  = rs.getString("Type");
			          int Status = rs.getInt("Status");
			          int Published = rs.getInt("Published");

			          //Display values
			          System.out.print("Type: " + Type);
			          System.out.print(", Status: " + Status);
			          System.out.println(", Published: " + Published);
			       }
			      
			      while(rs2.next()){
			    	  //Retrieve column name
			          String Museum = rs2.getString("Museum");
			          //Display values
			          System.out.println("Museum: " + Museum);
			      }

			      
			      rs.close();
			      rs2.close();
			      stmt.close();
			      conn.close();
			      
			      
				
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
			System.out.println("Goodbye!");
}

}
