package com.revature.menu;
/**
 * Concrete Menu for login Response
 * @author MuckJosh
 *
 */
public class LoginResponseMenu extends Menu {

	private String user;
	private int type;
	private boolean login;
	/**
	 * Constructor takes a input user string
	 * @param user input string from loginMenu.
	 */
	LoginResponseMenu(String user) {
		this.user = user;
	}
	/**
	 * Prints Menu and if login prints 
	 */
	@Override
	public Menu printMenu() {
		pause();
		if(login) {
			System.out.println(line);
			System.out.println("| Welcome " + user + "! |");
			return new MainMenu(user, type);
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
	/**
	 * simulate the computer thinking.
	 */
	private void pause() {
		long start = System.currentTimeMillis();
		long next;
		long run = 0;
		while(run < 1000) {
			next = System.currentTimeMillis();
			run = next - start;
		}
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
