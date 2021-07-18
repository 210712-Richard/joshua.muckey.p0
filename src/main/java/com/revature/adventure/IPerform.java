package com.revature.adventure;

public interface IPerform {
	
	default Room perform(Room currentRoom) {
		return currentRoom;
	}

}
