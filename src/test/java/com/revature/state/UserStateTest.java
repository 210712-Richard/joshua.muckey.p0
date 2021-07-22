package com.revature.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.users.User;
import com.revature.users.UserBase;
import com.revature.users.UserType;


public class UserStateTest {

	@InjectMocks
	private static UserState users;
	@Mock
	private static UserBase base;
	@Mock
	private static User u;
	
	
	@BeforeEach
	public void setupTests() {
		MockitoAnnotations.initMocks(this);
		base = Mockito.mock(UserBase.class);
		users.users = base;
		u = Mockito.mock(User.class);
		
	}
	@Test
	public void loginTest() {
		when(u.getUsername()).thenReturn("test");
		assertFalse(users.login(), "Check if user is in userBase");
		when(base.getUser(u.getUsername())).thenReturn(u);
		assertTrue(users.login(),"Check if pre-registered user is in");
	}
	@Test
	public void getTypeTest() {
		//first make sure users has a selected User
		when(base.getUser(u.getUsername())).thenReturn(u);
		users.login(u.getUsername());
		
		//next make sure user returns a usertype
		
		when(u.getType()).thenReturn(UserType.PLAYER);
		
		assertEquals(users.getType(), UserType.PLAYER.ordinal());
		//switch type
		when(u.getType()).thenReturn(UserType.ADMIN);
		
		assertNotEquals(users.getType(), UserType.PLAYER.ordinal());
	}
}
