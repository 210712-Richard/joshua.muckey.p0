package com.revature.adventure;

public class DoorAction extends Action {

	private Direction direction;
	
	public DoorAction(String description, Direction direction) {
		super(description);
		this.direction = direction;
	}

	@Override
	public Room perform(Room currentRoom) {
		
		return currentRoom.getAdjacentRooms().get(direction);
	}

}
