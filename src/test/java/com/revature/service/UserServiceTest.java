package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.revature.users.User;
import com.revature.users.UserBase;
import com.revature.users.UserType;

public class UserServiceTest {

	private static UserService service;
	private static User u;
	
	@BeforeAll // Specifies that this static method will be run before any tests
	public static void setUpClass() {
		u = new User("test");
	}
	
	@BeforeEach // Specifies a method that is to be run before each test
	public void setUpTests() {
		service = new UserService(); // create a new userService for every test to maximize isolation
		service.users = Mockito.mock(UserBase.class);
	}
	
	@Test
	public void testRegister() {
		String test = "test";
		service.register(u);

		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

		Mockito.verify(service.users).addUser(captor.capture());

		User u = captor.getValue();
		assertEquals(UserType.PLAYER, u.getType(), "Asserting it is a Player");
		assertEquals(test, u.getUsername(), "Asserting username is correct");
	}
	@Test
	public void login() {
		String test = "test";
		service.login(u);
		
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		
		Mockito.verify(service.users).getUser(captor.capture());
	}
	
}

