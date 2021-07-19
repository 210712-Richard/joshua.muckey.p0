package com.revature.adventure;
/**
 * Concrete Action by which of a door.
 * door opens to another room unless cannot.
 * @author MuckJosh
 *
 */
public class DoorAction extends Action {

	private Direction direction;
	private boolean isLocked = false;
	
	/**
	 * Constructor for basic door
	 * @param description open the door.
	 * @param direction which direction the door is.
	 */
	public DoorAction(String description, Direction direction) {
		super(description);
		this.direction = direction;
	}
	/**
	 * Constructor for basic door
	 * @param description open the door
	 * @param direction the direction of door
	 * @param isLocked is it locked?
	 */
	public DoorAction(String description, Direction direction, boolean isLocked) {
		super(description);
		this.direction = direction;
		this.isLocked = isLocked;
	}
	/**
	 * perform open door action to enter another room?
	 * @param always current room
	 * @see Action
	 */
	@Override
	public Room perform(Room currentRoom) {
		
		return currentRoom.getAdjacentRooms().get(direction);
	}

}
