package com.revature.state;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.users.User;
import com.revature.users.UserBase;
import com.revature.util.IDTO;
import com.revature.util.UserDTO;

public class UserService {

	public UserBase users = new UserBase();
	private User selectedUser = null;
	private IDTO<?> dto = null;
	
	public UserService() {
		
	}
	
	public boolean login() {
		
		@SuppressWarnings("unchecked")
		User attempt =((List<User>) dto.getData()).get(0);
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
	public boolean register() {
		User attempt = ((List<User>)dto.getData()).get(0);
		selectedUser = users.addUser(attempt.getUsername());
		if(selectedUser!= null) {
			UserDTO dto = new UserDTO(Stream.of(selectedUser).collect(Collectors.toList()));
			this.dto = dto;
			return true;
		}else {
			this.dto = null;
			return false;
		}
	}
	public void adminRequest() {
		Predicate<? super User> input = (Predicate<? super User>) dto.getData();
		UserDTO data = new UserDTO(users.getUsers(input));
		GameService.getGameService().putTransfer(data);
		
	}
	public void update() {
		List<User> list = ((List<User>) dto.getData());
		User original = list.get(0);
		User update = list.get(1);
		
		if(update.getUsername() != null && users.getUser(update.getUsername()) == null) {
			
			original.setUsername(update.getUsername());
		}
		
	}
	public void putTransfer(IDTO<?> dto) {
		this.dto = dto;
	}

	public  IDTO<?> getTransfer() {
		return dto;
	}
	

}
