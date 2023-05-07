package bean.articles;

import java.io.Serializable;

public class IndexBean implements Serializable{
	public IndexBean() {
		
	}
	
	private int article_id;
	private String title;
	private String text;
	private int user_id;
	
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getArticle_id() {
		return article_id;
	}
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
	public int getUser_id() {
		return user_id;
	}
}
