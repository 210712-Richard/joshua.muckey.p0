package com.revature.adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomTest {
	
	private static Room demoRoom;
	private static Room demoActionRoom;
	private String str;
	private Action action;
	
	@BeforeEach
	public void setupTest() {
		
		str = "description";
		action = new MoveAction(str, Direction.CURRENT);
		demoRoom = new NormalRoom(str);
		demoActionRoom = new NormalRoom(str, action);
		
	}
	@Test
	public void enterRoomTest() {
		// test if room calls description and actions
		
		//should return mock str
		assertEquals(demoRoom.enterRoom(),str);
		
		//mock action returns str
		assertEquals("\n0. "+str,demoActionRoom.displayActions());
		
		//check str + str is returned
		assertEquals(str+"\n0. "+str, demoActionRoom.enterRoom());
		
	}
}
