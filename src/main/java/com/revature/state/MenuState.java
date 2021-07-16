package com.revature.state;

import com.revature.menu.StartMenu;
import com.revature.menu.LoginResponseMenu;
import com.revature.menu.Menu;

public class MenuState {

	private Menu currentMenu;
	private String loginAttempt = null;
	private int type = 0;

	MenuState() {
		currentMenu = new StartMenu();
	}

	public void openMenu() {
		while (currentMenu != null) {
			currentMenu = currentMenu.printMenu();
			if(currentMenu instanceof LoginResponseMenu) {
				LoginResponseMenu temp = ((LoginResponseMenu)currentMenu);
				loginAttempt = temp.getUser();
				temp.setType(type);
				temp.setLogin(GameState.notifyLogin());
			}
		}
	}

	public String getAttempt() {
		return loginAttempt;
	}

	public void successfulLogin() {
		System.out.println("Successful Login " + (type == 1 ? "Admin!" : "Player"));
	}

	public void type(int type) {
		this.type = type;
	}

}
