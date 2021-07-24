package com.revature.menu;

import com.revature.state.GameService;
/**
 * Class to notify 
 * @author MuckJosh
 *
 */
public class QuitMenu extends Menu {

	@Override
	public Menu printMenu() {
		System.out.println("Bye!");
		GameService.getGameService().notifyQuit();
		return null;
	}

}
