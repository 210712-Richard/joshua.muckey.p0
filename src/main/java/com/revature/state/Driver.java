package com.revature.state;

import com.revature.adventure.Adventure;
import com.revature.adventure.Direction;
import com.revature.adventure.DoorAction;
import com.revature.adventure.NormalRoom;
import com.revature.adventure.Room;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\" + "base\\base";
//		Adventure adventure = new Adventure(null, "base\\base");
//		Room foyer = new NormalRoom("You are in the Foyer with 4 doors and a picture of a person", new DoorAction("west door", Direction.LEFT, false), 
//				new DoorAction("North door", Direction.UP, true),
//				new DoorAction("South door", Direction.DOWN, true),
//				new DoorAction("east Door", Direction.RIGHT, true));
//		Room gallery1 = new NormalRoom("You are in a gallery with 4 doors.",new DoorAction("east door", Direction.LEFT, false), 
//				new DoorAction("South door", Direction.DOWN, false),
//				new DoorAction("West Door", Direction.RIGHT, false));
//		Room gallery2 = new NormalRoom("You are in a gallery with 4 doors.",new DoorAction("east door", Direction.LEFT, false), 
//				new DoorAction("North door", Direction.UP, false),
//				new DoorAction("South door", Direction.DOWN, false),
//				new DoorAction("West Door", Direction.RIGHT, false));
//		Room great = new NormalRoom("You are in a Great Room with 2 doors.",new DoorAction("west door", Direction.LEFT, false), 
//				new DoorAction("South door", Direction.DOWN, true));
//		Room maid = new NormalRoom("You are in a maids room with 1 door.", new DoorAction("east door", Direction.RIGHT, false));
//		Room library = new NormalRoom("You are in a Library with 1 door.", new DoorAction("door", Direction.UP, false));
//		
//		foyer.getAdjacentRooms().put(Direction.UP, great);
//		foyer.getAdjacentRooms().put(Direction.RIGHT, gallery2);
//		foyer.getAdjacentRooms().put(Direction.LEFT, gallery1);
//		foyer.getAdjacentRooms().put(Direction.DOWN, new NormalRoom("Ending"));
//		
//		gallery1.getAdjacentRooms().put(Direction.RIGHT, foyer);
//		gallery1.getAdjacentRooms().put(Direction.DOWN, library);
//		gallery1.getAdjacentRooms().put(Direction.LEFT, maid);
//		
//		gallery2.getAdjacentRooms().put(Direction.LEFT, foyer);
//		gallery2.getAdjacentRooms().put(Direction.DOWN, new NormalRoom("kitchen"));
//		gallery2.getAdjacentRooms().put(Direction.RIGHT, new NormalRoom("Dinning"));
//		gallery2.getAdjacentRooms().put(Direction.UP, new NormalRoom("Family"));
//		
//		great.getAdjacentRooms().put(Direction.DOWN, foyer);
//		
//		maid.getAdjacentRooms().put(Direction.RIGHT, gallery1);
//		
//		library.getAdjacentRooms().put(Direction.UP, gallery1);
//		
//		adventure.list.rooms.add(foyer);
//		adventure.list.rooms.add(gallery1);
//		adventure.list.rooms.add(gallery2);
//		adventure.list.rooms.add(great);
//		adventure.list.rooms.add(maid);
//		adventure.list.rooms.add(library);
//		
//		adventure.save("base\\base");
//		
		GameState game = new GameState();
		game.run();
	}

}
