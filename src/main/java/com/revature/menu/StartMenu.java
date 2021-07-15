package com.revature.menu;

import com.revature.util.SingletonScanner;

public class StartMenu extends Menu {
	
	private Menu[] arr = {new LoginMenu(), new RegisterMenu()};

	@Override
	public Menu printMenu() {
		
				System.out.println(line);
				System.out.println("|Welcome to Text Adventure!|");
				System.out.println("|"+repeatedString(5,  " ")+"By Joshua Muckey" +repeatedString(5, " ")+"|");
				System.out.println("|What would you like to do?|");
				System.out.println("|"+"\t1. Login"+ repeatedString(11, " ")+"|");
				System.out.println("|"+"\t2. Register" + repeatedString(8, " ")+"|");
				System.out.println("\t3. Quit");
				int selection;
				try {
					selection = Integer.parseInt(SingletonScanner.getScanner().getNext());
				} catch(Exception e) {
					selection = -1;
				}
				//log
				return menuSelection(selection);
	}

	private Menu menuSelection(int selection) {
		if(selection >= arr.length)
			return new QuitMenu();
		return arr[selection-1];
	}

}
