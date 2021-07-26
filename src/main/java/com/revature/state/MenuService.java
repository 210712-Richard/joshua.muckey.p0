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

public class MenuService {

	private Menu currentMenu;
	private static User user = null;

	public MenuService() {
		currentMenu = new StartMenu();
	}

	public void openMenu() {
		while (currentMenu != null) {
			currentMenu = currentMenu.printMenu();
			if(currentMenu instanceof LoginResponseMenu) {
				LoginResponseMenu temp = (LoginResponseMenu)currentMenu;
				UserDTO dto = new UserDTO(Stream.of(currentMenu.getUser()).collect(Collectors.toList()));
				GameService.getGameService().putTransfer(dto);
				GameService.getGameService().notifyLogin();
				user = ((List<User>)GameService.getGameService().getTransfer().getData()).get(0);
				GameService.getGameService().putTransfer(dto);
				GameService.getGameService().notifyLogin();
				user = ((List<User>)GameService.getGameService().getTransfer().getData()).get(0);
				if(user != null) {
					Menu.setUser(user);
					temp.setLogin(true);
				}
			}else if(currentMenu instanceof RegisterResponseMenu) {
				RegisterResponseMenu temp = ((RegisterResponseMenu) currentMenu);
				UserDTO dto = new UserDTO(Stream.of(temp.getUser()).collect(Collectors.toList())); 
				GameService.getGameService().putTransfer(dto);
				GameService.getGameService().notifyRegister();
				user = ((List<User>)GameService.getGameService().getTransfer().getData()).get(0);
				GameService.getGameService().putTransfer(dto);
				GameService.getGameService().notifyRegister();
				user = ((List<User>)GameService.getGameService().getTransfer().getData()).get(0);
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
