package com.revature.menu;

import com.revature.util.IDTO;
import com.revature.util.SingletonScanner;

public class RegisterMenu extends Menu {
	
	private String user;

	@Override
	public Menu printMenu() {
		System.out.println(line);
		System.out.println("| Thank you for registering! |");
		System.out.println("| Username cannot be any form of \"quit\"|");
		System.out.println("|      To quit type quit     |");
		System.out.println("|"+"Enter Username: "+ Menu.repeatedString(11, " ")+"|");
		user = SingletonScanner.getScan().next();
		if(user.equalsIgnoreCase("quit")) {
			return new LoginMenu();
		}
		System.out.println("Thank you! attempting to register you now!");
		System.out.println(line);
		
		//log
		return new RegisterResponseMenu();
	}

	@Override
	public IDTO<?> report() {
		// TODO Auto-generated method stub
		return null;
	}

}
