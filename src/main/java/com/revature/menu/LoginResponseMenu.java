package com.revature.menu;
/**
 * Concrete Menu for login Response
 * @author MuckJosh
 *
 */
public class LoginResponseMenu extends Menu {

	private boolean login;
	/**
	 * Constructor takes a input user string
	 * @param user input string from loginMenu.
	 */
	LoginResponseMenu() {
		
	}
	/**
	 * Prints Menu and if login prints 
	 */
	@Override
	public Menu printMenu() {
		if(login) {
			
			System.out.println(line);
			System.out.println("| Welcome " + user.getUsername() + "! |");
			return new MainMenu();
		}
		System.out.println();
		System.out.println(line);
		System.out.println("| Sorry, " + user + " is not a User|");
		System.out.println("|     Please try again!    |");
		System.out.println(blank);
		System.out.println(line);
		System.out.println();
		return new LoginMenu();
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

}
