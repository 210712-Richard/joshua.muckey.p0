package com.revature.menu;

import com.revature.util.SingletonScanner;

public class LoginMenu extends Menu {

	@Override
	public Menu printMenu() {
		System.out.println(line);
		System.out.println("");
		System.out.println("| Please enter username  ");
		String user = SingletonScanner.getScanner().getNext();
		return new LoginResponseMenu(user);
	}
}

