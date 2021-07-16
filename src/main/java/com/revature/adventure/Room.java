package com.revature.adventure;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Room implements Serializable{

	/**
	 * Model of adventure tile
	 */
	private static final long serialVersionUID = -740387222736760593L;

	private String description;
	private LinkedList<IAction> takeableActions = new LinkedList<IAction>();
	private Room nextRoom;
	private Room previousRoom;
	
	public abstract void enterRoom();
	public abstract void setupRoom();

	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	public final LinkedList<IAction> getTakeableActions() {
		return takeableActions;
	}
	public final void setTakeableActions(LinkedList<IAction> takeableActions) {
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
