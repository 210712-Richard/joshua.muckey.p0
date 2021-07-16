package com.revature.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.users.User;
import com.revature.users.UserType;

public class UserStateTest {

	private static UserState users;
	private static User u;
	
	
	@BeforeEach
	public void setupTests() {
		users = new UserState();
		u = new User("test");
		
	}
	@Test
	public void loginTest() {
		assertFalse(users.login(u.getUsername()), "Check if user is in userBase");
		assertTrue(users.login("joshua"),"Check if pre-registered user is in");
	}
	@Test
	public void getTypeTest() {
		//first make sure users has a selected User
		users.login("joshua");
		assertEquals(users.getType(), UserType.PLAYER.ordinal());
		assertNotEquals(users.getType(), UserType.PLAYER.ordinal());
	}
}
