import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;

public class teststuff {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connection conn = null;
		
		String uri = "jdbc:mysql://leia.skip.chalmers.se:3306/team_03";
		final String username = "team_03";
		final String password = "CVpgphn7i0vvLvoU";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Opening a connection
			System.out.println("Connecting to database.....");
			conn = DriverManager.getConnection(uri, username, password);
			System.out.println("Connected... i think");
			
			String query = "SELECT email FROM USERS WHERE type = 'admin' ";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery(query);
			

			

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame;
				try {
					teststuff window = new teststuff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

	/**
	 * Create the application.
	 */
	//public teststuff() {
		//initialize();
	//}

	/**
	 * Initialize the contents of the frame.
	 */
	//public void initialize() {
		
		JFrame frame;	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateNewPoi = new JButton("Flagged Comments");
		btnCreateNewPoi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCreateNewPoi.setBounds(371, 78, 130, 39);
		frame.getContentPane().add(btnCreateNewPoi);
		
		JLabel lblAdministratorPage = new JLabel("Administrator Page");
		lblAdministratorPage.setBounds(12, 0, 120, 16);
		frame.getContentPane().add(lblAdministratorPage);
		
		JButton btnVerifyOwner = new JButton("Owner Accounts");
		btnVerifyOwner.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVerifyOwner.setBounds(371, 131, 130, 39);
		frame.getContentPane().add(btnVerifyOwner);
		
		JLabel lblNewLabel = new JLabel("Account information");
		lblNewLabel.setBounds(12, 45, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email: " + query);
		lblNewLabel_1.setBounds(12, 89, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(440, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(12, 116, 74, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(12, 143, 74, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnVerified = new JRadioButton("Verified");
		rdbtnVerified.setBounds(12, 291, 74, 23);
		frame.getContentPane().add(rdbtnVerified);
		
		}catch(SQLException ex){
			System.out.println("Shit is hitting the fan.");
			ex.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}

