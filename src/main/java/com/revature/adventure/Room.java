package com.revature.adventure;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

/**
 * abstract Model or bean of a Room
 * @author MuckJosh
 *
 */
public abstract class Room implements Serializable{

	private static final long serialVersionUID = -740387222736760593L;

	private String description;
	private EnumMap<Direction, Room> adjacentRooms = new EnumMap<Direction, Room>(Direction.class);
	private LinkedList<Action> takeableActions = new LinkedList<Action>();
	/**
	 * Rooms require a description but also require an action.
	 * @param description 
	 */
	private Room(String description) {
		super();
		adjacentRooms.put(Direction.CURRENT, this);
		this.setDescription(description);
	}
	/**
	 * Rooms require an action
	 * @param description please describe room0
	 * @param action requires any number of actions specifically leaving room.
	 */
	public Room(String description, Action... action) {
			this(description);
			for(Action a: action) {
				takeableActions.add(a);
			}
	}
	/**
	 * Rooms require an action
	 * @param description please describe room0
	 * @param actions requires any number of actions specifically leaving room.
	 */
	public Room(String description, List<Action> actions) {
		this(description);
		for(Action a: actions) {
			takeableActions.add(a);
		}
	}
	
	public abstract String displayActions();
	public abstract String enterRoom();

	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	public final LinkedList<Action> getTakeableActions() {
		return takeableActions;
	}
	public final void setTakeableActions(LinkedList<Action> takeableActions) {
		this.takeableActions = takeableActions;
	}	
	public final EnumMap<Direction, Room> getAdjacentRooms() {
		return adjacentRooms;
	}
	public final void setAdjacentRooms(EnumMap<Direction, Room> adjacentRooms) {
		this.adjacentRooms = adjacentRooms;
	}
}
