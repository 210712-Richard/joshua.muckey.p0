package com.revature.state;

import com.revature.adventure.Adventure;
import com.revature.util.AdventureDTO;

public class AdventureState {

	private Adventure adventure = null;

	public AdventureState(String userAdventureFile, String userName) {
		adventure = new Adventure(userAdventureFile, userName);
		start();
	}

	private void start() {
		AdventureDTO dto = new AdventureDTO(adventure.run());
		GameState.putTransfer(dto);

	}
	public void update() {
		String str = adventure.takeAction((Integer) GameState.getTransfer().getData());
		AdventureDTO dto = new AdventureDTO(str);
		GameState.putTransfer(dto);
		adventure.save();
		
	}

}
