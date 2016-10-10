
public class user {
	
	int user_id;
	String username;
	String email;
	String password;
	String status;
	
	// User constructor
	public user(int user_id, String username, String email, String password, String status){
		this.user_id = user_id; 
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public user( String username, String email){
		this.username = username;
		this.email = email;

	}
	
	// 
	public String getUserName(){
	
		return this.username;
	
	}
	
	// 
	public String getEmail(){
	
		return this.email;
	
	}
	
	// 
	public String getStatus(){
	
		return this.status;
	
	}
	
}
