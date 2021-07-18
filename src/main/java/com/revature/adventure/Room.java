package com.revature.adventure;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Room implements Serializable{

	/**
	 * Model of adventure tile
	 */
	private static final long serialVersionUID = -740387222736760593L;

	private String description;
	private LinkedList<Action> takeableActions = new LinkedList<Action>();
	
	public Room(String description) {
		super();
		this.setDescription(description);
	}
	public Room(String description, Action... action) {
			this.description = description;
			for(Action a: action) {
				takeableActions.add(a);
			}
	}
	public Room(String description, List<Action> actions) {
		this.description = description;
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
}
