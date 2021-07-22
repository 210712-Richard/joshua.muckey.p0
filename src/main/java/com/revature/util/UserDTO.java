package com.revature.util;

import java.util.List;

import com.revature.users.User;


public class UserDTO implements IDTO<List<User>> {

	private List<User> list;
	
	public UserDTO(List<User> list) {
		this.list = list;
	}
	@Override
	public List<User> getData() {
		
		return list;
	}

}
