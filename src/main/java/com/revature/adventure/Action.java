
package com.revature.adventure;

import java.io.Serializable;
import java.util.Observable;

/**
 * Action is the base for any action taken in a room.
 * 
 * @author MuckJosh
 * @see Room
 */

public abstract class Action extends Observable implements IPerform, Serializable{

	private static final long serialVersionUID = 667751492414922077L;
	private String description;
	private boolean display = true;
	
	/**
	 * <h1>Constructor for a base action</h1>
	 * <p>A description of the action is required for printing</p>
	 * @param description description of the action.
	 */
	public Action(String description) {
		super();
		this.description = description;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param Room should always take in currentRoom to alter currentRoom 
	 * after action or change rooms connected to current room
	 */
	public abstract Room perform(Room currentRoom);

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
