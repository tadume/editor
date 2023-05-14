package bean.users;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountDTO implements Serializable{
	private ArrayList<AccountBean> list;
	
	public AccountDTO(){
		list = new ArrayList<AccountBean>();
	}
	
	public AccountBean get(int i) {
		return list.get(i);
	}
	
	public void add(AccountBean ab) {
		list.add(ab);
	}
	
	public int size() {
		return list.size();
	}
}
