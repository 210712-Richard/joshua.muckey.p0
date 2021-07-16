package com.revature.adventure;

public class BeginningRoom extends Room {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520006592776000893L;
	
	public BeginningRoom() {
		setupRoom();
	}
	
	@Override
	public void enterRoom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupRoom() {
		this.setDescription("First Room!");
		
		
	}

}
