package com.revature.adventure;

import java.util.List;

public class BeginningRoom extends Room {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520006592776000893L;
	
	public BeginningRoom(String description) {
		super(description);
	}
	public BeginningRoom(String description, Action... action) {
		super(description, action);
	}
	public BeginningRoom(String description, List<Action> actions) {
		super(description, actions);
	}
	@Override
	public String enterRoom() {
		return this.getDescription()+displayActions();
	}
	@Override
	public String displayActions() {
		StringBuilder sb = new StringBuilder();
//		for(IAction action: this.getTakeableActions()) {
//			sb.append(action.Action());
//		}
		return sb.toString();
	}

}
