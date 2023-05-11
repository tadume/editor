package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import bean.users.AccountBean;

public class AccountRegisterDAO {
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
	
	public int select(AccountBean ab) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO users(name, password, email) VALUES(?, ?, ?)";
		int cnt = 0;
		
		try {
			connect();
			ps = con.prepareStatement(sql);
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getPassword());
			ps.setString(3, ab.getEmail());
			
			cnt = ps.executeUpdate();
			
			if(cnt != 0) {
				System.out.println("新規会員登録成功！");
			}else {
				System.out.println("新規登録失敗( ﾉД`)ｼｸｼｸ…");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return cnt;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public int emailFind(AccountBean ab) {
//		Statement stmt = null;
//		ResultSet rs = null;
//		String sql = "SELECT email FROM users";
//		AccountBean eb = new AccountBean();
//		int i = 0;
//		int cnt = 0;
//		
//		try {
//			connect();
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				if(rs.getString("email") == ab.getEmail()) {
//					i++;
//				}
//			}
//			if(i == 0) {
//				cnt = select(ab);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(stmt != null)stmt.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		disconnect();
//		return cnt;
//	}
	
}
