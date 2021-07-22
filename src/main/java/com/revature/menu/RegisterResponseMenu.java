package com.revature.menu;

import com.revature.users.User;

public class RegisterResponseMenu extends Menu {

	private boolean isRegistered = false;
	
	public RegisterResponseMenu() {
		
	}

	@Override
	public Menu printMenu() {
		if(isRegistered) {
			return new MainMenu();
		}
		System.out.println("Sorry failed please try again");
		return new RegisterMenu();
	}

	public User getUser() {
		return user;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
}
