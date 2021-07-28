package com.revature.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.adventure.Adventure;

public class AdventureServiceTest {

	private static AdventureService service;
	private static Adventure adventure;
	

	@BeforeEach public void setUpTests() {
		service = new AdventureService();
		adventure = Mockito.mock(Adventure.class);
		service.setAdventure(adventure);
	}
	
	@Test public void testStart() {
		
		service.start();
		Mockito.verify(adventure).run();	
	}
	@Test public void testUpdate() {
		
		service.update("");
		Mockito.verify(adventure).run();
		
		service.update("1");
		Mockito.verify(adventure).takeAction(1);
	}

}
