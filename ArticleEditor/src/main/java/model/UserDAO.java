package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.users.AccountBean;
import bean.users.AccountDTO;

public class UserDAO {
	private final String URL = "jdbc:mysql://localhost/Articleeditordb";
	private final String USER = "root";
	private final String PASS = "pass";
	private Connection con = null;
	
	public void connect() {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("接続されました。");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AccountDTO select() {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT name FROM users";
		AccountDTO adto = new AccountDTO();
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AccountBean ab = new AccountBean();
				ab.setName(rs.getString("name"));
				adto.add(ab);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null)stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return adto;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
