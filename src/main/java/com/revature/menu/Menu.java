package com.revature.menu;

public class Menu {
	
	private final String dash = "-";
	private final String space = " ";

	public int startMenu() {
		//log
		System.out.println("|"+repeatedString(26, dash) + "|");
		System.out.println("|Welcome to Text Adventure!|");
		System.out.println("|"+repeatedString(5, space)+"By Joshua Muckey" +repeatedString(5, space)+"|");
		System.out.println("|What would you like to do?|");
		System.out.println("|"+"\t1. Login"+ repeatedString(11, space)+"|");
		System.out.println("|"+"\t2. Register" + repeatedString(8, space)+"|");
		System.out.println("\t3. Quit");
		int selection;
		try {
			//selection = Integer.parseInt(scan.nextLine());
		} catch(Exception e) {
			selection = -1;
		}
		//log
		return -1;
	}
	private String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
}
