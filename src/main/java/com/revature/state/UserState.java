package com.revature.state;

import com.revature.users.User;
import com.revature.users.UserBase;

public class UserState {

	public UserBase users = new UserBase();
	private User selectedUser = null;
	
	public boolean login(String attempt) {
		selectedUser = users.getUser(attempt);
		return selectedUser != null ? true : false;
	}
	public int getType() {
		return selectedUser.getType().ordinal();
	}
	public void save() {
		users.save();
	}

}
