package com.revature.menu;


/**
 * Abstracted Implementation of the Menu blueprint
 * 
 * @author MuckJosh
 *
 */
public abstract class Menu {
	
	protected String line = new String("|"+repeatedString(26, "-") + "|");
	protected String blank = new String("|"+repeatedString(26," ")+"|");

	/**
	 * method to print menu.
	 * user input is generally needed uses {@link #SingletonScanner}
	 * 
	 * @return returns a menu to keep menu's populating
	 * @see SingletonScanner
	 */
	public abstract Menu printMenu();
	/**
	 * repeated string for ease formating of spaces, dashes, and |.
	 * @param x number of times repeated
	 * @param c string to repeat
	 * @return returns a string of that repeat.
	 */
	protected static String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
}
