package com.revature.state;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.users.User;
import com.revature.users.UserBase;
import com.revature.util.UserDTO;

public class UserService {

	public UserBase users = new UserBase();
	private User selectedUser = null;
	
	
	public boolean login() {
		
		@SuppressWarnings("unchecked")
		User attempt =((List<User>)GameService.getGameService().getTransfer().getData()).get(0);
		selectedUser = users.getUser(attempt.getUsername());
		if(selectedUser!= null) {
			UserDTO dto = new UserDTO(Stream.of(selectedUser).collect(Collectors.toList()));
			GameService.getGameService().putTransfer(dto);
			return true;
		}else {
			GameService.getGameService().putTransfer(null);
			return false;
		}
		
	}
	public int getType() {
		return selectedUser.getType().ordinal();
	}
	public String getUserAdventureFile() {
		return selectedUser.getAdventureFileName();
	}
	public String getUsername() {
		return selectedUser.getUsername();
	}
	public void save() {
		users.save();
	}
	public void register() {
		User attempt = ((List<User>)GameService.getGameService().getTransfer().getData()).get(0);;
		selectedUser = users.addUser(attempt.getUsername());
		if(selectedUser!= null) {
			UserDTO dto = new UserDTO(Stream.of(selectedUser).collect(Collectors.toList()));
			GameService.getGameService().putTransfer(dto);
		}else {
			GameService.getGameService().putTransfer(null);
		}
	}
	public void adminRequest() {
		Predicate<? super User> input = (Predicate<? super User>) GameService.getGameService().getTransfer().getData();
		UserDTO data = new UserDTO(users.getUsers(input));
		GameService.getGameService().putTransfer(data);
		
	}
	

}