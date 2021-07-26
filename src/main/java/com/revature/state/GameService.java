package com.revature.state;

import com.revature.util.IDTO;

public class GameService {

	private static GameService instance;
	private MenuService menu = new MenuService();
	
	private IDTO<?> dto = null;

	private GameService() {
	}
	
	public static synchronized GameService getGameService() {
		if(instance == null) {
			instance =  new GameService();
		}
		return instance;
	}
	public void run() {
		menu.openMenu();
	}

	public void putTransfer(IDTO<?> dto) {
		this.dto = dto;
	}

	public  IDTO<?> getTransfer() {
		return dto;
	}

	public void notifyQuit() {
		UserService.getUserService().save();
	}

	public void notifyAdventure() {
		adventure.update();
	}

	public void notifyStart() {
		//TODO
		adventure = new AdventureService(user.getUserAdventureFile(), user.getUsername());

	}

}
