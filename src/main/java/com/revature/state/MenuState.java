package com.revature.state;

import com.revature.menu.StartMenu;
import com.revature.users.User;
import com.revature.util.UserDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.menu.LoginResponseMenu;
import com.revature.menu.Menu;
import com.revature.menu.RegisterResponseMenu;

public class MenuState {

	private Menu currentMenu;
	private User user = null;

	MenuState() {
		currentMenu = new StartMenu();
	}

	public void openMenu() {
		while (currentMenu != null) {
			currentMenu = currentMenu.printMenu();
			if(currentMenu instanceof LoginResponseMenu) {
				LoginResponseMenu temp = (LoginResponseMenu)currentMenu;
				UserDTO dto = new UserDTO(Stream.of(currentMenu.getUser()).collect(Collectors.toList()));
				GameState.putTransfer(dto);
				GameState.notifyLogin();
				user = ((List<User>)GameState.getTransfer().getData()).get(0);
				if(user != null)
					temp.setLogin(true);
			}else if(currentMenu instanceof RegisterResponseMenu) {
				RegisterResponseMenu temp = ((RegisterResponseMenu) currentMenu);
				UserDTO dto = new UserDTO(Stream.of(temp.getUser()).collect(Collectors.toList())); 
				GameState.putTransfer(dto);
				GameState.notifyRegister();
				user = ((List<User>)GameState.getTransfer().getData()).get(0);
				if(user != null) 
					temp.setRegistered(true);
			}
		}
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
