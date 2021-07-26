package com.revature.menu;

import java.util.List;

import com.revature.state.GameService;
import com.revature.users.User;
import com.revature.users.UserType;
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
		for (int i = 0; i < splits.length; i++) {
			if (i == 0) {
				System.out.println(splits[i]);
			} else if(i == splits.length-1 && Menu.user.getType().ordinal() != 1){
				System.out.println(splits[i]);
			}else {
				System.out.println(i + ". " + splits[i]);
			}
		}
		int x;
		System.out.println("To modify user input line number:");
		try {
		x = Integer.parseInt(SingletonScanner.getScan().nextLine());
		}catch(NumberFormatException e) {
			return new MainMenu();
		}
		switch (x) {
		case 1:
			System.out.println("Please input new userName");
			String str = SingletonScanner.getScan().nextLine();
			if (str.isEmpty() || str.equalsIgnoreCase("quit"))
				return this;
			User name = new User(str);
			UserDTO dto = new UserDTO(user, name);
			GameService.getGameService().putTransfer(dto);
			GameService.getGameService().updateName();
			user = ((List<User>) GameService.getGameService().getTransfer().getData()).get(0);
			return new InfoMenu(user);
			
		case 2:
			System.out.println("Reset Adventure (Y or N)");
			String ans = SingletonScanner.getScan().nextLine();
			if(ans.contains("y") || ans.contains("Y")) {
				user.setAdventureFileName(null);
				UserDTO dto2 = new UserDTO(user);
				GameService.getGameService().putTransfer(dto2);
				GameService.getGameService().updateUser();
				return new InfoMenu(user);
			}
			return this;
		case 3:
			if(Menu.user.getType().ordinal() != 1) {
				System.out.println("Not unauthorized!");
				return this;
			}else {
				System.out.println("Change to Admin(Y or N):");
				String admin = SingletonScanner.getScan().nextLine();
				if(admin.contains("y") || admin.contains("Y")) {
					user.setType(UserType.ADMIN);
					UserDTO dto3 = new UserDTO(user);
					GameService.getGameService().putTransfer(dto3);
					GameService.getGameService().updateUser();
					return new InfoMenu(user);
				}
				return this;
			}
		default:
			return new MainMenu();
		}
	}

}
