package com.revature.state;

public class GameState {

		private MenuState menu = new MenuState();
		private UserState user = new UserState();
		private static boolean loginAttempt = false;
		private static boolean quit = false;
		
		
		public void run() {
			while(true) {
				menu.openMenu();
				if(loginAttempt) {
					if(user.login(menu.getAttempt())) {
						menu.successfulLogin();
						menu.type(user.getType());
						loginAttempt = false;
					}else {
						loginAttempt = false;
						menu.tryAgain();
					}	
				}else if(quit) {
					
					user.save();
					break;
				}
			}
		}

		public static void notifyLogin() {
			loginAttempt = true;
		}

		public static void notifyQuit() {
			quit = true;
		}
}
