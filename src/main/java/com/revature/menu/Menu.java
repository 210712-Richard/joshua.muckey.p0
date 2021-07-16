package com.revature.menu;

public abstract class Menu {
	
	//String dash = "-";
	//String space = " ";
	String line = new String("|"+repeatedString(26, "-") + "|");
	String blank = new String("|"+repeatedString(26," ")+"|");

	public abstract Menu printMenu();
	
	static String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
	static void quit() {
		System.out.println("Bye!");
	}
}
