package com.revature.adventure;


public class InterAction extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8168348443234390566L;
	private Checkpoint point;
	private Boolean isPassed = false;
	public InterAction(String description, Checkpoint point) {
		super(description);
		this.point = point;
		// TODO Auto-generated constructor stub
	}
	public InterAction(String description, Checkpoint point, boolean display) {
		super(description);
		this.setPoint(point);
		this.setDisplay(display);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Room perform(Room currentRoom) {
		if(!isDisplay())
			return currentRoom;
		isPassed = true;
		setChanged();
		notifyObservers(isPassed);
		this.setDisplay(false);
		return currentRoom;
	}
	public Checkpoint getPoint() {
		return point;
	}
	public void setPoint(Checkpoint point) {
		this.point = point;
	}

}
