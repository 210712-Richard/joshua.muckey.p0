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
		case 2://register
			menuOptions.registerMenu();
			break;
		case 3://quit
			menuOptions.quit();
			GameState.notifyQuit();
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
		System.out.println("Successful Login!");
		
		
	}

	public void tryAgain() {

		System.out.println("Sorry try again");
		
	}

}
