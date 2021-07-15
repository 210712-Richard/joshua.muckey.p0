package com.revature.state;

import com.revature.menu.Menu;

public class MenuState {
	
	private Menu menuOptions = new Menu();
	private String loginAttempt = null;
	
	public void openMenu() {
		switch(menuOptions.startMenu()) {
		case 1://login
			loginAttempt = menuOptions.loginMenu();
			GameState.notifyLogin();
			break;
		case 2:
			menuOptions.registerMenu();
			break;
		case 3:
			menuOptions.quit();
			break;
		default:
			System.out.println("Invalid Response please try again.");
			openMenu();
		}
				
	}
	
	public String getAttempt() {
		return loginAttempt;
	}

	public void successfulLogin() {
		// TODO Auto-generated method stub
		System.out.println("Successful!");
		
	}

	public void tryAgain() {

		System.out.println("Sorry try again");
		
	}

}
