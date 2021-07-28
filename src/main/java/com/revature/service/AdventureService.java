package com.revature.service;

import com.revature.adventure.Adventure;

public class AdventureService {

	private Adventure adventure;

	protected final Adventure getAdventure() {
		return adventure;
	}

	protected final void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public AdventureService(String userAdventureFile, String userName) {
		adventure = new Adventure(userAdventureFile, userName);
		start();
	}

	public String start() {
		return adventure.run();

	}
	public AdventureService() {
		super();
	}

	public String update(String num) {
		int x = -1;
		try {
			x = Integer.parseInt(num);
		}catch(NumberFormatException e) {
			return adventure.run();
		}
		String str = adventure.takeAction(x);
		adventure.save();
		return str;
		
	}

}
