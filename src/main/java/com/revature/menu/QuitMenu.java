package com.revature.menu;

import com.revature.state.GameState;

public class QuitMenu extends Menu {

	@Override
	public Menu printMenu() {
		System.out.println("Bye!");
		GameState.notifyQuit();
		return null;
	}

}
