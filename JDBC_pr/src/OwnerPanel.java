import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OwnerPanel {
	
	private JFrame frame;

	public static void OwnerFrame() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerPanel window = new OwnerPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}
	
	Connection conn = null;
	public OwnerPanel() {
		initialize();	
		conn = Connect.connection();
	}
	
	
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

}
