package com.revature.menu;

import com.revature.util.SingletonScanner;

public class Menu {
	//
	private final String dash = "-";
	private final String space = " ";
	private final String header = new String("|"+repeatedString(26, dash) + "|");

	public int startMenu() {
		//log
		System.out.println(header);
		System.out.println("|Welcome to Text Adventure!|");
		System.out.println("|"+repeatedString(5, space)+"By Joshua Muckey" +repeatedString(5, space)+"|");
		System.out.println("|What would you like to do?|");
		System.out.println("|"+"\t1. Login"+ repeatedString(11, space)+"|");
		System.out.println("|"+"\t2. Register" + repeatedString(8, space)+"|");
		System.out.println("\t3. Quit");
		int selection;
		try {
			selection = Integer.parseInt(SingletonScanner.getScanner().getNext());
		} catch(Exception e) {
			selection = -1;
		}
		//log
		return selection;
	}
	private String repeatedString(int x, String c) {
		return new String(new char[x]).replace("\0", c);
	}
	public void quit() {
		// TODO Auto-generated method stub
		System.out.println("Bye!");
	}
	public void registerMenu() {
		// TODO Auto-generated method stub
		
	}
	public String loginMenu() {
		// TODO Auto-generated method stub
		System.out.println(header);
		System.out.println("");
		System.out.println("| Please enter username  ");
		return SingletonScanner.getScanner().getNext();
	}
}
