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
	private AdventureService adventure;
	private UserService userService;
	private static User user = null;

	private MenuService() {
		currentMenu = new StartMenu();
		userService = new UserService();
	}

	public void openMenu() {
		while (currentMenu != null) {
			currentMenu = currentMenu.printMenu();
			if(currentMenu instanceof LoginResponseMenu) {
				LoginResponseMenu temp = (LoginResponseMenu)currentMenu;
				UserDTO dto = new UserDTO(Stream.of(currentMenu.getUser()).collect(Collectors.toList()));
				userService.putTransfer(dto);
				if(userService.login())
					user = ((List<User>)userService.getTransfer().getData()).get(0);
					Menu.setUser(user);
					temp.setLogin(true);
			}else if(currentMenu instanceof RegisterResponseMenu) {
				RegisterResponseMenu temp = ((RegisterResponseMenu) currentMenu);
				UserDTO dto = new UserDTO(Stream.of(temp.getUser()).collect(Collectors.toList())); 
				userService.putTransfer(dto);
				if(userService.register()) { 
					temp.setRegistered(true);
					user = ((List<User>)userService.getTransfer().getData()).get(0);
				}
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
