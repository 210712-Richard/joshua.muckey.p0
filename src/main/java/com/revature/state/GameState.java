package com.revature.state;

import com.revature.util.IDTO;

public class GameState {

	private static MenuState menu = new MenuState();
	private static UserState user = new UserState();
	private static AdventureState adventure = null;
	private static IDTO<?> dto = null;

	public void run() {
		menu.openMenu();
	}

	public static void notifyLogin() {
			user.login();
		}

	public static void putTransfer(IDTO<?> dto) {
		GameState.dto = dto;
	}

	public static IDTO<?> getTransfer() {
		return dto;
	}

	public static void adminRequet() {
		user.adminRequest();
	}

	public static void notifyRegister() {
		user.register();
	}

	public static void notifyQuit() {
		user.save();
	}

	public static void notifyAdventure() {
		adventure.update();
	}

	public static void notifyStart() {
		adventure = new AdventureState(user.getUserAdventureFile(), user.getUsername());

	}
}
