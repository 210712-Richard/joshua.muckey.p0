package com.revature.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserBaseTest {
	public static UserBase base;
	public static User u;
	
	@BeforeEach
	public void setupTest() {
		base = new UserBase();
		u = new User("test");
	}
	
	@Test
	public void getUserTest() {
		//check for user in list
		assertFalse(base.getUser(u) instanceof User,"should not retrieve test user");
	}
	@Test
	public void addUserTest() {
		
		//insert User
		assertEquals(u = base.addUser(u), u ,"should return same user" );
	}
	@Test
	public void removeUserTest() {
		//remove user TDD
		//add user
		assertEquals(u = base.addUser(u), u ,"should return same user" );
		// remove user
		assertEquals(u = base.removeUser(u), u ,"should return same user" );
	}

}
