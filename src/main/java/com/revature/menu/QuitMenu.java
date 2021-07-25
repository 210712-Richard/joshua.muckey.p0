package com.revature.menu;

import com.revature.state.GameService;
import com.revature.util.IDTO;
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

	@Override
	public IDTO<?> report() {
		// TODO Auto-generated method stub
		return null;
	}

}
