package com.revature.state;

import com.revature.adventure.Adventure;
import com.revature.util.AdventureDTO;

public class AdventureService {

	private Adventure adventure = null;

	public AdventureService(String userAdventureFile, String userName) {
		adventure = new Adventure(userAdventureFile, userName);
		start();
	}

	private void start() {
		AdventureDTO dto = new AdventureDTO(adventure.run());
		GameService.getGameService().putTransfer(dto);

	}
	public void update() {
		String str = adventure.takeAction((Integer) GameService.getGameService().getTransfer().getData());
		AdventureDTO dto = new AdventureDTO(str);
		GameService.getGameService().putTransfer(dto);
		adventure.save();
		
	}

}
