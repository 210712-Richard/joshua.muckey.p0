package com.revature.users;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.revature.util.DataSerializer;

public class UserBase implements Serializable{
	
	private static final long serialVersionUID = -938251342446948320L;
	//this class handles user data
	private MyList list;
	private static final String userDataBase = System.getProperty("user.dir")+"\\src\\main\\resources\\users.dat";
	
	class MyList implements Serializable{
		//wrapper class to make serialization easier
		private static final long serialVersionUID = -1701834769473473555L;
		private LinkedList<User> users;
		
	}
	
	public UserBase() {
		load();
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
	
	public User addUser(String username) {
			User temp = new User(username);
			if(list.users.contains(temp))
				return null;
			list.users.add(temp);
		return temp;
	}
	public User removeUser(String username) {
		
		for(int i = 0; i<list.users.size()-1; i++) {
			if(list.users.get(i).getUsername().equals(username)) {
				User temp = list.users.get(i);
				list.users.remove(i);
				return temp;
			}	
		}
		return null;
	}
	public User updateUser(User user) {
		for(User u: list.users) {
			if(user.getUsername().equals(u.getUsername())) {
				u = user;
				return u;
			}
		}
		return null;
	}
	public List<User> getUsers(Predicate<? super User> input){
		return list.users.stream().filter(input).collect(Collectors.toList());
				
	}
	
	public void save() {
		DataSerializer<MyList> ds = new DataSerializer<MyList>();
		ds.writeObjectsToFile(list, userDataBase);
	}
	public void load() {
		DataSerializer<MyList> ds = new DataSerializer<MyList>();
		try {
			list = (MyList) ds.readObjectFromFile(userDataBase);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
