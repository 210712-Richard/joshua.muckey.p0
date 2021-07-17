package com.revature.state;

public class GameState {

		private static MenuState menu = new MenuState();
		private static UserState user = new UserState();
		
		
		public void run() {
			menu.openMenu();
		}

		public static boolean notifyLogin() {
			if(user.login(menu.getAttempt())) {
				menu.type(user.getType());
				return true;
			}
			return false;
		}

		public static void notifyQuit() {
			user.save();	
		}
}
