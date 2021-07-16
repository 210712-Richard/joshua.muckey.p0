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
		if(login) {
			System.out.println(line);
			System.out.println("| Welcome " + user + "! |");
			return new MainMenu(user, type);
		}
		return null;
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
