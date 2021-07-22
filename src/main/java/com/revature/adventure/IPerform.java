package com.revature.adventure;

import java.io.Serializable;

/*
 * every action should perform that action
 */
public interface IPerform extends Serializable{
	/**
	 * performing action
	 * @param currentRoom always take in current room to alter room.
	 * @return default would keep you in the same room.
	 */
	default Room perform(Room currentRoom) {
		return currentRoom;
	}

}
