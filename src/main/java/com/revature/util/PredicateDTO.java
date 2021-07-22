package com.revature.util;

import java.util.function.Predicate;

import com.revature.users.User;

public class PredicateDTO implements IDTO<Predicate<User>> {

	private String input;
	
	public PredicateDTO(String input) {
		super();
		this.input = input;
	}
	
	@Override
	public Predicate<User> getData() {
		if(input.isEmpty() || input == null)
			return p -> p != null;
		return p -> p.getUsername().contains(input);
	}

}
