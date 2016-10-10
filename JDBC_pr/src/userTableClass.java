import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class userTableClass extends AbstractTableModel{
	
		public String[] colName = {"UserName","Email","Status"};
	    private List<user> users;

	    public userTableClass(List<user> users) {

	        this.users = new ArrayList<user>(users);

	    }

	    @Override
	    public int getRowCount() {
	        return users.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return 3;
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {

	        Object value = "??";
	        user user = users.get(rowIndex);
	        switch (columnIndex) {
	            case 0:
	                value = user.getUserName();
	                break;
	            case 1:
	                value = user.getEmail();
	                break;
	            case 2:
	                value = user.getStatus();
	                break;
	        }

	        return value;

	    }

	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        return user.class; // Return the class that best represents the column...
	    }
	    
        @Override 
        public String getColumnName(int index) { 
            return colName[index]; 
        } 

	    /* Override this if you want the values to be editable...
	    @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        //....
	    }
	    */

	    /**
	     * This will return the user at the specified row...
	     * @param row
	     * @return 
	     */
	    public user getUserAt(int row) {
	        return users.get(row);
	    }

	
}
