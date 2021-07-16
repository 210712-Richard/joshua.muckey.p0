package com.revature.menu;

import com.revature.util.SingletonScanner;

public class LoginMenu extends Menu {

	@Override
	public Menu printMenu() {
		System.out.println(line);
		System.out.println("| To go back enter: \"exit\" |");
		System.out.println(blank);
		System.out.println("| Please enter username: ");
		String user = SingletonScanner.getScanner().getNext();
		if(user.equalsIgnoreCase("exit"))
			return new StartMenu();
		return new LoginResponseMenu(user);
	}
}

