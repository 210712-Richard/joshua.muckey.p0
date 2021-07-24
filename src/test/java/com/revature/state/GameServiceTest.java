package com.revature.state;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GameServiceTest {
	
	@InjectMocks
	private GameService game;
	
	@Mock(name="menu")
	private MenuService menu;
	@Mock(name="user")
	private MenuService user;
	@Mock(name="adventure")
	private AdventureService adventure;
	
	@BeforeEach
	public void setupTest() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void menuVerifyTest() {

		game.run();
		verify(menu,times(1)).openMenu();
		
	}
	

}
