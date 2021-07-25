package com.revature.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.users.User;


public class UserDTO implements IDTO<List<User>> {

	private List<User> list;
	
	public UserDTO(List<User> list) {
		this.list = list;
	}
	public UserDTO(User... user) {
		this.list = Stream.of(user).collect(Collectors.toList());
	}
	@Override
	public List<User> getData() {
		
		return list;
	}

}
