package com.revature.menu;

import com.revature.users.User;
import com.revature.util.SingletonScanner;
import com.revature.util.UserDTO;


/**
 * Concrete of Menu used for Login functions.
 * 
 * @author MuckJosh
 */
public class LoginMenu extends Menu {

	private User attempt;
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
		attempt = new User(user);
		return new LoginResponseMenu();
	}

	@Override
	public UserDTO report() {
		// TODO Auto-generated method stub
		return new UserDTO(attempt);
	}
}
