package com.revature.state;

import com.revature.util.IDTO;

public class GameService {

	private static GameService instance;
	private MenuService menu = new MenuService();
	private UserService user = new UserService();
	private AdventureService adventure;
	
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
	public void notifyLogin() {
		user.putTransfer(dto);
		user.login();
	}

	public void adminRequet() {
		user.putTransfer(dto);
		user.adminRequest();
	}

	public void notifyRegister() {
		user.putTransfer(dto);
		user.register();
	}

	public void notifyQuit() {
		user.putTransfer(dto);
		user.save();
	}

	public void notifyAdventure() {
		adventure.update();
	}

	public void notifyStart() {
		//TODO
		adventure = new AdventureService(user.getUserAdventureFile(), user.getUsername());

	}

	public void updateName() {
		user.putTransfer(dto);
		user.update();
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		user.putTransfer(dto);
		user.update();
	}

}
