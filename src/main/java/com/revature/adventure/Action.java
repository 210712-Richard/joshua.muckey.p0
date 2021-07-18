package com.revature.adventure;

public abstract class Action implements IPerform{

	private String description;
	
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
	public abstract Room perform(Room currentRoom);

}
