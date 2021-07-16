package com.revature.adventure;

import java.io.Serializable;

public abstract class Room implements Serializable{

	/**
	 * Model of adventure tile
	 */
	private static final long serialVersionUID = -740387222736760593L;

	private String description;
	private IAction[] takeableActions;
	private Room nextRoom;
	private Room previousRoom;
	
	public Room(String description, IAction[] takeableActions) {
		super();
		this.description = description;
		this.takeableActions = takeableActions;
	}
	
	public Room(String description, IAction[] takeableActions, Room nextRoom, Room previousRoom) {
		super();
		this.description = description;
		this.takeableActions = takeableActions;
		this.nextRoom = nextRoom;
		this.previousRoom = previousRoom;
	}
	public abstract void enterRoom();

	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	public final IAction[] getTakeableActions() {
		return takeableActions;
	}
	public final void setTakeableActions(IAction[] takeableActions) {
		this.takeableActions = takeableActions;
	}
	public final Room getNextRoom() {
		return nextRoom;
	}
	public final void setNextRoom(Room nextRoom) {
		this.nextRoom = nextRoom;
	}
	public final Room getPreviousRoom() {
		return previousRoom;
	}
	public final void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}
	
	
}
