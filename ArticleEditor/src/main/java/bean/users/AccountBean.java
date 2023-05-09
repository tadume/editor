package bean.users;

import java.io.Serializable;

public class AccountBean implements Serializable{
	private int user_id;
	private String name;
	private String password;
	private String email;
	
	public AccountBean() {
		
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
}
