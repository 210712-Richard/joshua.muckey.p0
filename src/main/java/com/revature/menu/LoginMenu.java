package com.revature.menu;

import com.revature.users.User;
import com.revature.util.SingletonScanner;


/**
 * Concrete of Menu used for Login functions.
 * 
 * @author MuckJosh
 */
public class LoginMenu extends Menu {

	/**
	 * User input is grabbed and addressed in response. exit is a restricted string.
	 */
	@Override
	public Menu printMenu() {
		System.out.println(line);
		System.out.println("| To go back enter: \"exit\" |");
		System.out.println(blank);
		System.out.println("| Please enter username: ");
		String user = SingletonScanner.getScanner().getNext();
		if (user.equalsIgnoreCase("exit"))
			return new StartMenu();
		User temp = new User(user);
		Menu.user = temp;
		return new LoginResponseMenu();
	}
}
