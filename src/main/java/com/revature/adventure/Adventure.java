package com.revature.adventure;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;


import com.revature.util.DataSerializer;

/**
 * Controls Adventure data with CRUD
 * 
 * @author MuckJosh
 *
 */

public class Adventure implements Serializable {

	private static final long serialVersionUID = 5530775947993281960L;
	public AdventureList list;
	private String userName;
	
	private final String base = "base\\base";
	private final String adventureFolder = System.getProperty("user.dir") + "\\src\\main\\resources\\adventureFiles\\";

	/**
	 * Wrapper for easy data storage.
	 * 
	 * @author MuckJosh
	 *
	 */
	public class AdventureList implements Serializable {

		private static final long serialVersionUID = -2919344589691125636L;
		public LinkedList<Room> rooms = new LinkedList<Room>();
		private Room currentRoom = null;
	}

	public Adventure(String userAdventureFile, String userName) {
		this.userName = userName;
		load(userName);
		if (list == null) {
			 load(base);
			 save();
		}

	}

	public void save() {
		DataSerializer<AdventureList> ds = new DataSerializer<AdventureList>();
		ds.writeObjectsToFile(list, adventureFolder + userName + ".dat");
	}

	public void load() {

		DataSerializer<AdventureList> ds = new DataSerializer<AdventureList>();
		try {
			list = (AdventureList) ds.readObjectFromFile(adventureFolder + userName + ".dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			load(base);
			save();
		}
	}
	private void load(String base) {

		DataSerializer<AdventureList> ds = new DataSerializer<AdventureList>();
		try {
			list = (AdventureList) ds.readObjectFromFile(adventureFolder + base + ".dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			save();
		}
	}

	/**
	 * Method is designed to start adventure where left off.
	 * 
	 * @return String
	 * @see Room
	 */
	public String run() {
		if(list.currentRoom == null)
			 list.currentRoom = list.rooms.get(0);
		return list.currentRoom.enterRoom();
	}

	public String takeAction(Integer x) {
		Room temp = list.currentRoom;
		list.currentRoom = list.currentRoom.getTakeableActions().get(x).perform(list.currentRoom);
		if (temp.equals(list.currentRoom))
			return list.currentRoom.displayActions();
		return list.currentRoom.enterRoom();
	}
}
