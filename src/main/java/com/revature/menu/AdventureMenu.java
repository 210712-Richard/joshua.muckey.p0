package com.revature.menu;

import com.revature.state.GameState;
import com.revature.util.InputDTO;
import com.revature.util.SingletonScanner;

public class AdventureMenu extends Menu {

	private String data = null;
	private static boolean isFirst = false;
	
	public AdventureMenu() {
	}

	@Override
	public Menu printMenu() {
		System.out.println("type quit to quit at anytime!");
		if(isFirst == false) {
			GameState.notifyStart();
			isFirst = true;
		}
		data = (String) GameState.getTransfer().getData();
		System.out.println(data);
		String str = null;
		try{
			str = SingletonScanner.getScan().nextLine();
			Integer x = Integer.parseInt(str);
			GameState.putTransfer(new InputDTO(x));
			GameState.notifyAdventure();
			return new AdventureMenu();
		}catch(NumberFormatException e) {
			if(str.equalsIgnoreCase("quit")) {
				isFirst = false;
				return new MainMenu();
			}
			return this;
		}
	}


}
