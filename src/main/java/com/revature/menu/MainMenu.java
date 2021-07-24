package com.revature.menu;

import com.revature.users.UserType;
import com.revature.util.SingletonScanner;

public class MainMenu extends Menu {

	private Menu[] menuArr = new Menu[4];
	
	@Override
	public Menu printMenu() {
		menuArr[0] = new AdventureMenu();
		menuArr[1] = new InfoMenu(user);
		menuArr[2] = new StartMenu();
		menuArr[3] = new UserManageMenu();
		System.out.println(line);
		System.out.println("|  Main Menu  |");
		System.out.println(line);
		System.out.println("|1. Start Adventure");
		System.out.println("|2. User Info ");
		System.out.println("|3. logout ");
		if(Menu.user.getType() == UserType.ADMIN) {
			System.out.println("| 4. Manage Users |");
		}
		
		System.out.println("if you want to quit type quit");
		System.out.println(line);

		String selection = SingletonScanner.getScan().nextLine();
		if(selection == null) {
			return this;
		}else if(selection.equalsIgnoreCase("quit"))
			return new QuitMenu();
		else {
			try {
				int x = Integer.parseInt(selection);
				if(x == 4 && type == 1)
					return this;
				return menuArr[x-1];
			}catch(NumberFormatException | IndexOutOfBoundsException e1) {
				System.out.println("try again");
				return this;
			}
		}
	}

	public MainMenu() {
		
	}

}
