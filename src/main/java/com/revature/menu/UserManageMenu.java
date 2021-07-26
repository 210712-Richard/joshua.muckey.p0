package com.revature.menu;

import java.util.List;

import com.revature.state.GameService;
import com.revature.users.User;
import com.revature.util.PredicateDTO;
import com.revature.util.SingletonScanner;

public class UserManageMenu extends Menu {

	@Override
	public Menu printMenu() {
		System.out.println("Welcome Admin");
		System.out.println("|\t1. User List");
		System.out.println("|\t2. Get Info on one\n");
		System.out.println("|\t3. Back");
		Integer x = Integer.parseInt(SingletonScanner.getScan().nextLine());
		//TODO remove data transfer to MenuState
		PredicateDTO data = null;
		switch(x) {
		case 3:
			return new MainMenu();
		case 2:
			System.out.println("Please input username(can be partial):");
			String uInput = SingletonScanner.getScan().nextLine();
			
			data = new PredicateDTO(uInput);
			break;
		case 1:
			data = new PredicateDTO("");
			break;
		}
		
		GameService.getGameService().putTransfer(data);
		GameService.getGameService().adminRequet();
		List<User> users = (List<User>) GameService.getGameService().getTransfer().getData();
		if(users.size() == 1) {
			return new InfoMenu(users.get(0));
		}
		
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
		
		System.out.println("To select a user input an id number:");
		Integer input;
		try {
			input = Integer.parseInt(SingletonScanner.getScan().nextLine());
			}catch(NumberFormatException e) {
				return new MainMenu();
			}
		
		User user = users.stream().filter(p->p.getId().equals(input)).findFirst().get();
		
		return new InfoMenu(user);
	}


}
