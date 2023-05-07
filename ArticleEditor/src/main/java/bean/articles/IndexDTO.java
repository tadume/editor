package bean.articles;

import java.io.Serializable;
import java.util.ArrayList;

public class IndexDTO implements Serializable{
	private ArrayList<IndexBean> list;
	
	public IndexDTO() {
		list = new ArrayList<IndexBean>();
	}
	
	public void add(IndexBean ib) {
		list.add(ib);
	}
	
	public IndexBean get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
	
}
