package com.revature.menu;

public class LoginResponseMenu extends Menu {

	private String user;
	private int type;
	private boolean login;

	LoginResponseMenu(String user) {
		this.user = user;
	}

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
