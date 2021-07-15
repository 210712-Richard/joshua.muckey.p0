package com.revature.menu;

import com.revature.util.SingletonScanner;

public abstract class Menu {
	//
	private final String dash = "-";
	private final String space = " ";
	protected final String line = new String("|"+repeatedString(26, dash) + "|");

	public abstract Menu printMenu();
	
	protected String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
	public void quit() {
		System.out.println("Bye!");
	}
	public void registerMenu() {
		// TODO Auto-generated method stub
		
	}
	public String loginMenu() {
		// TODO Auto-generated method stub
		System.out.println(line);
		System.out.println("");
		System.out.println("| Please enter username  ");
		return SingletonScanner.getScanner().getNext();
	}
}
