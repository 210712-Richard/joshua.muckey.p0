package com.revature.state;

import com.revature.models.User;
import com.revature.models.UserBase;

public class UserState {

	private UserBase users = new UserBase();
	private User selectedUser = null;
	
	public boolean login(String attempt) {
		selectedUser = users.getUser(attempt);
		return selectedUser != null ? true : false;
		
	}

}
