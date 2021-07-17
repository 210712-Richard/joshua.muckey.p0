package com.revature.menu;

public abstract class Menu {
	
	protected String line = new String("|"+repeatedString(26, "-") + "|");
	protected String blank = new String("|"+repeatedString(26," ")+"|");

	public abstract Menu printMenu();
	
	protected static String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
}
