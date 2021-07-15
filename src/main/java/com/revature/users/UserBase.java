package com.revature.users;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.revature.util.DataSerializer;

public class UserBase implements Serializable{
	//this class handles user data
	private static final long serialVersionUID = 5529604745131923690L;
	private MyList list = new MyList();
	private final String userDataBase = System.getProperty("user.dir")+"\\src\\main\\java\\com\\revature\\resources\\users.dat";
	
	class MyList implements Serializable{
		//wrapper class to make serialization easier
		private static final long serialVersionUID = -1701834769473473555L;
		private List<User> users;
		
	}
	
	public UserBase() {
		DataSerializer<MyList> ds = new DataSerializer<MyList>();
		list = (MyList) ds.readObjectFromFile(userDataBase);
		if(list == null) {
			System.out.println("new list");
			list = new MyList();
			list.users = new LinkedList<User>();
			list.users.add(new User("joshua"));
			list.users.add(new User("richard"));
			list.users.add(new User("ivan"));
			User u = new User("admin");
			u.setType(UserType.ADMIN);
			list.users.add(u);
		}
	}
	
	public User getUser(String username) {
		for(User u: list.users) {
			if(u.getUsername().equals(username)){
				return u;
			}
		}
		return null;
	}
	
	public void save() {
		DataSerializer<MyList> ds = new DataSerializer<MyList>();
		ds.writeObjectsToFile(list, userDataBase);
	}
	
	

}
