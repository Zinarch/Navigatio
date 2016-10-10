
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.border.TitledBorder;
//import org.eclipse.wb.swing.FocusTraversalOnArray;



public class Main {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	private JTable table;
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();	
		conn = SQL_Handler.connection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		try{	
			
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel AdminPage = new JPanel();
		frame.getContentPane().add(AdminPage, "name_632966394527269");
				AdminPage.setLayout(null);
				AdminPage.setVisible(true);
				
				JPanel OwnerStatus = new JPanel();
				frame.getContentPane().add(OwnerStatus, "name_632966432012394");
				OwnerStatus.setLayout(null);
				OwnerStatus.setVisible(false);
				JButton button = new JButton("Back");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AdminPage.setVisible(true);
						OwnerStatus.setVisible(false);
					}
				});
				button.setBounds(0, 0, 100, 25);
				OwnerStatus.add(button);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(40, 94, 658, 285);
				OwnerStatus.add(scrollPane);
				System.out.println("innan userobject");
				user userObject = new user(QueryHandler.getAdmin().getString(1), QueryHandler.getAdmin().getString(2), QueryHandler.getAdmin().getString(3));
				//user userObject2 = new user(QueryHandler.selectMany().get(1).get(0).toString(),QueryHandler.selectMany().get(1).get(1).toString(),QueryHandler.selectMany().get(1).get(2).toString());
				
				System.out.println(userObject.getEmail());
				System.out.println(userObject.getStatus());
				System.out.println(userObject.getUserName());
				// Epic shit
				List<user> userList = new ArrayList<user>();
				for(int i =0; i < QueryHandler.getOwners().size(); i++){
					userList.add(new user(QueryHandler.getOwners().get(i).get(0).toString(),QueryHandler.getOwners().get(i).get(1).toString(),QueryHandler.getOwners().get(i).get(2).toString()));
				}
				
				
			
				
				
				//List<user> userList = new ArrayList<user>();
				//userList.add(userObject);
				//userList.add(userObject2);
				
				// Superior stuff
				userTableClass tableModel = new userTableClass(userList);
				
				System.out.println(tableModel.getUserAt(0).getUserName());
				JTable table = new JTable(tableModel);
				
			
				
				scrollPane.setViewportView(table);
				
				
				
				
				
				
				
				
				
				
				
				
				JLabel lblAdministratorPage = new JLabel("Administrator Page");
				lblAdministratorPage.setBounds(12, 30, 130, 16);
				AdminPage.add(lblAdministratorPage);
				
				JButton btnVerifyOwner = new JButton("Owner Accounts");
				btnVerifyOwner.setBounds(565, 150, 130, 48);
				AdminPage.add(btnVerifyOwner);
				btnVerifyOwner.setFont(new Font("Tahoma", Font.PLAIN, 10));
				btnVerifyOwner.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				        AdminPage.setVisible(false);
				        OwnerStatus.setVisible(true);
				    }
				    
				});
				
				
				
				
				
				JLabel lblNewLabel_1 = new JLabel("Email:  " + userObject.getEmail());
				lblNewLabel_1.setBounds(12, 150, 233, 16);
				AdminPage.add(lblNewLabel_1);
				
				
				JLabel lblNewLabel = new JLabel("Account information");
				lblNewLabel.setBounds(12, 104, 130, 16);
				AdminPage.add(lblNewLabel);
				
				JButton btnLogOut = new JButton("Log out");
				btnLogOut.setBounds(582, 273, 99, 25);
				AdminPage.add(btnLogOut);
				
				JLabel lblNewLabel_2 = new JLabel("Username:  " + userObject.getUserName());
				lblNewLabel_2.setBounds(12, 183, 189, 16);
				AdminPage.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Password:  ****");
				lblNewLabel_3.setBounds(12, 211, 145, 16);
				AdminPage.add(lblNewLabel_3);
				
				JButton btnEdit = new JButton("Edit");
				btnEdit.setBounds(257, 146, 97, 25);
				AdminPage.add(btnEdit);
				
				JButton btnEdit_1 = new JButton("Edit");
				btnEdit_1.setBounds(257, 179, 97, 25);
				AdminPage.add(btnEdit_1);

				btnLogOut.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				        System.exit(0);
				    }
				    
				});
		}catch(Exception e){
			
		}
	}
}
