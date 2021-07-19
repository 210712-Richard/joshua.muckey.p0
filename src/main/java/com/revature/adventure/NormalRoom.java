package com.revature.adventure;

import java.util.List;
/**
 * Concrete Room - Normal Room 
 * @author MuckJosh
 *
 */
public class NormalRoom extends Room {

	private static final long serialVersionUID = -7520006592776000893L;
	
	/**
	 * Every normal room has to lead to another room.
	 * 
	 * @param description description of room
	 * @param action any action in that room
	 * @see Action
	 */
	public NormalRoom(String description, Action... action) {
		super(description, action);
	}
	/**
	 * Every normal room has to lead to another room.
	 * 
	 * @param description description of room
	 * @param actions any action in that room
	 * @see Action
	 */
	public NormalRoom(String description, List<Action> actions) {
		super(description, actions);
	}
	/**
	 * Displays description and actions upon entering room
	 * @see Room
	 * @return String of description and action
	 */
	@Override
	public String enterRoom() {
		return this.getDescription()+displayActions();
	}
	/**
	 * Displays just actions if an action changed a room's actions or 
	 * if invalid entry
	 * @see Room
	 * @return String of description and action
	 */
	@Override
	public String displayActions() {
		StringBuilder sb = new StringBuilder();
		for(Action action: this.getTakeableActions()) {
			sb.append(action.getDescription());
		}
		return sb.toString();
	}

}
