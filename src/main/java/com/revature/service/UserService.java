package com.revature.service;

import java.util.List;
import com.revature.users.User;
import com.revature.users.UserBase;
import com.revature.users.UserType;

public class UserService {

	public UserBase users = new UserBase();
	private User selectedUser = null;

	
	public UserService() {
		
	}
	
	public User login(User u) {
		selectedUser = users.getUser(u);
		return selectedUser;
		
	}
	public int getType() {
		return selectedUser.getType().ordinal();
	}
	public String getUserAdventureFile() {
		return selectedUser.getAdventureFileName();
	}
	public String getUsername() {
		return selectedUser.getUsername();
	}
	private void save() {
		users.save();
	}
	public User register(User attempt) {
		User newUser = new User(attempt.getUsername());
		selectedUser = users.addUser(newUser);
		save();
		if(selectedUser!= null)
			return selectedUser;
		return null;
		
	}
	public List<User> adminRequest(String predicate) {
		return users.getUsers(predicate);
		
	}
	public User update(String id, User update) {
		int x = 0;
		User original = null;
		try {
			x = Integer.parseInt(id);
			original = users.getUser(x);
		}catch(NumberFormatException e) {
			return null;
		}
		
		if(original == null) {
			return null;
		}
		
		if(!original.getUsername().equals(update.getUsername()) && users.getUser(update) == null){
			original.setUsername(update.getUsername());
		}
		if(selectedUser.getType() == UserType.ADMIN && !original.getType().equals(update.getType())) {
			original.setType(update.getType());
		}

		users.save();
		return original;
		
	}

}
