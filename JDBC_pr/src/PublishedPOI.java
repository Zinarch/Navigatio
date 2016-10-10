import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PublishedPOI {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		Scanner userInp = new Scanner(System.in);
		String uri = "jdbc:mysql://localhost:3306/testdb1";
		final String username = "Sebastian";
		final String password = "ch13875th";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connecting to database.....");
			conn = DriverManager.getConnection(uri, username, password);
			System.out.println("Connected... i think");
			
			System.out.println("Do you wish to add a point of interest? 1=Yes, 2=No");
			int test = userInp.nextInt();
			
			if(test==1){
				
			}
			else if(test==2){
				
			}
			
			
			}catch(SQLException ex){
			System.out.println("Shit is hitting the fan.");
			ex.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
				
			}

	}

}
