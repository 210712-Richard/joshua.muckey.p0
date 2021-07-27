package com.revature.service;

import com.revature.adventure.Adventure;

public class AdventureService {

	private Adventure adventure = null;

	public AdventureService(String userAdventureFile, String userName) {
		adventure = new Adventure(userAdventureFile, userName);
		start();
	}

	public String start() {
		return adventure.run();

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
