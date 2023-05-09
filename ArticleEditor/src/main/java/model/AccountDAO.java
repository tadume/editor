package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.users.AccountBean;

public class AccountDAO {
	
	private final String URL = "jdbc:mysql://localhost/Articleeditordb";
	private final String USER = "root";
	private final String PASS = "pass";
	private Connection con = null;
	
	
	public void connect() {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AccountBean findAccount(AccountBean ab) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE password = ? AND email = ?";
		AccountBean returnAb = new AccountBean();
		
		try {
			connect();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ab.getPassword());
			ps.setString(2, ab.getEmail());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				returnAb.setUser_id(rs.getInt("user_id"));
				returnAb.setName(rs.getString("name"));
				returnAb.setPassword(rs.getString("password"));
				returnAb.setEmail(rs.getString("email"));
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return returnAb;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
