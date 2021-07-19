package com.revature.adventure;

/*
 * every action should perform that action
 */
public interface IPerform {
	/**
	 * performing action
	 * @param currentRoom always take in current room to alter room.
	 * @return default would keep you in the same room.
	 */
	default Room perform(Room currentRoom) {
		return currentRoom;
	}

}
