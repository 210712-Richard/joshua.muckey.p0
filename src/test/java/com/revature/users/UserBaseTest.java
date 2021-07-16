package com.revature.users;

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
	}

}
