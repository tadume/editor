package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.articles.IndexBean;
import bean.articles.IndexDTO;

public class ArticleDAO {
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
	
	public IndexDTO select() {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM articles";
		IndexDTO idto = new IndexDTO();
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				IndexBean ib = new IndexBean();
				ib.setArticle_id(rs.getInt("article_id"));
				ib.setTitle(rs.getString("title"));
				ib.setText(rs.getString("text"));
				ib.setUser_id(rs.getInt("user_id"));
				idto.add(ib);
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
		return idto;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
