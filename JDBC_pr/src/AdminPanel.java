
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import org.eclipse.wb.swing.FocusTraversalOnArray;



public class AdminPanel {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();	
		conn = Connect.connection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		try{	
			
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateNewPoi = new JButton("Flagged Comments");
		btnCreateNewPoi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCreateNewPoi.setBounds(574, 79, 130, 39);
		frame.getContentPane().add(btnCreateNewPoi);
		
		JLabel lblAdministratorPage = new JLabel("Administrator Page");
		lblAdministratorPage.setBounds(12, 13, 120, 16);
		frame.getContentPane().add(lblAdministratorPage);
		
		JButton btnVerifyOwner = new JButton("Owner Accounts");
		btnVerifyOwner.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVerifyOwner.setBounds(574, 132, 130, 39);
		frame.getContentPane().add(btnVerifyOwner);
		btnVerifyOwner.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        OwnerPanel.OwnerFrame();
		    }
		    
		});
		
		
		JLabel lblNewLabel = new JLabel("Account information");
		lblNewLabel.setBounds(12, 79, 120, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email:  " + ResStatement.result().getString(1));
		lblNewLabel_1.setBounds(12, 114, 198, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(643, 381, 89, 23);
		frame.getContentPane().add(btnLogOut);
		btnLogOut.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        System.exit(0);
		    }
		    
		});
		
		JLabel lblNewLabel_2 = new JLabel("Username:  " + ResStatement.user().getString(1));
		lblNewLabel_2.setBounds(12, 143, 175, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(12, 173, 74, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		JButton btnNewButton = new JButton("POIs");
		btnNewButton.setBounds(574, 194, 130, 39);
		frame.getContentPane().add(btnNewButton);
		//frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), btnCreateNewPoi, lblAdministratorPage, btnVerifyOwner, lblNewLabel, lblNewLabel_1, btnLogOut, lblNewLabel_2, lblNewLabel_3, rdbtnVerified, chckbxVerified, btnNewButton}));
		}catch(Exception e){
			
		}
	}
}