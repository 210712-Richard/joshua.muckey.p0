package com.revature.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserBaseTest {
	public static UserBase base;
	
	@BeforeEach
	public void setupTest() {
		base = new UserBase();
		
		
	}
	
	@Test
	public void getUserTest() {
		//check for user in list
		assertTrue(base.getUser("joshua") instanceof User, "should return user class");
		assertFalse(base.getUser("test") instanceof User,"should not retrieve test user");
	}
	@Test
	public void addUserTest() {
		//adding user TDD
		
		//create username String
		String username = "test";
		User u;
		//insert User
		assertEquals(u = base.addUser(username), u ,"should return same user" );
	}
	@Test
	public void removeUserTest() {
		//remove user TDD
		//create user.
		String username = "test";
		User u;
		//add user
		assertEquals(u = base.addUser(username), u ,"should return same user" );
		// remove user
		assertEquals(u = base.removeUser(username), u ,"should return same user" );
	}

}
