package com.revature.adventure;
/**
 * Concrete Action by which of a door.
 * door opens to another room unless cannot.
 * @author MuckJosh
 *
 */
public class MoveAction extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5318965894231906722L;
	private Direction direction;
	private boolean isLocked = false;
	
	/**
	 * Constructor for basic door
	 * @param description open the door.
	 * @param direction which direction the door is.
	 */
	public MoveAction(String description, Direction direction) {
		super(description);
		this.direction = direction;
	}
	/**
	 * Constructor for basic door
	 * @param description open the door
	 * @param direction the direction of door
	 * @param isLocked is it locked?
	 */
	public MoveAction(String description, Direction direction, boolean isLocked) {
		super(description);
		this.direction = direction;
		this.setLocked(isLocked);
	}
	/**
	 * perform open door action to enter another room?
	 * @param always current room
	 * @see Action
	 */
	@Override
	public Room perform(Room currentRoom) {
		if(this.isLocked) {
			return currentRoom;
		}
		return currentRoom.getAdjacentRooms().get(direction);
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

}
