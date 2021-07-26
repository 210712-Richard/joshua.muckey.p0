package com.revature.menu;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.state.GameService;
import com.revature.users.User;
import com.revature.util.SingletonScanner;
import com.revature.util.UserDTO;

public class InfoMenu extends Menu {

	private User user;
	public InfoMenu(User user) {
		this.user = user;
	}

	@Override
	public Menu printMenu() {
		
		String[] splits = user.toString().replaceAll("\\[", "\n").replaceAll("\\]", "").split(",");
		for(int i = 0; i<splits.length; i++) {
			if(i == 0) {
				System.out.println(splits[i]);
			}else {
				System.out.println(i+". "+splits[i]);
			}
		}
		
		System.out.println("To modify user input line number:");
		int x = Integer.parseInt(SingletonScanner.getScan().nextLine());
		
		switch(x) {
		case 1:
			System.out.println("Please input new userName");
			String str = SingletonScanner.getScan().nextLine();
			User name = new User(str);
			UserDTO dto = new UserDTO(Stream.of(user, name).collect(Collectors.toList()));
			GameService.getGameService().putTransfer(dto);
			GameService.getGameService().update();
			break;
		}
		
		return null;
	}

}
