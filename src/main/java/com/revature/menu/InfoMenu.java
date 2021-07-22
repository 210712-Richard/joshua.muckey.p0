package com.revature.menu;

import com.revature.users.User;
import com.revature.util.SingletonScanner;

public class InfoMenu extends Menu {

	private User user;
	public InfoMenu(User user) {
		this.user = user;
	}

	@Override
	public Menu printMenu() {
		int i = 1;
		String str = user.toString().replaceAll(",", "\n" + i++);
		System.out.println(str);
		
		System.out.println("To modify user input line number:");
		SingletonScanner.getScan().nextInt();
		return null;
	}

}
