package com.revature.models;

import java.io.Serializable;
import java.util.List;

import com.revature.util.DataSerializer;

public class UserBase implements Serializable{
	//this class handles user data
	private static final long serialVersionUID = 5529604745131923690L;
	private MyList list;
	private final String userDataBase = "users.dat";
	
	class MyList implements Serializable{
		//wrapper class to make serialization easier
		private static final long serialVersionUID = -1701834769473473555L;
		private List<User> users;
	}
	
	public UserBase() {
		DataSerializer<MyList> ds = new DataSerializer<MyList>();
		list = (MyList) ds.readObjectFromFile(userDataBase);
		if(list == null) {
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
	
	

}
