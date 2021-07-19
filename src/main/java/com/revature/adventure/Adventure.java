package com.revature.adventure;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Controls Adventure data with CRUD 
 * @author MuckJosh
 *
 */

public class Adventure implements Serializable{

	private static final long serialVersionUID = 5530775947993281960L;
	private AdventureList list;
	private int index;

	/**
	 * Wrapper for easy data storage. 
	 * @author MuckJosh
	 *
	 */
	private class AdventureList implements Serializable{
		
		private static final long serialVersionUID = -2919344589691125636L;
		private LinkedList<Room> rooms = new LinkedList<Room>();
		
	}
	/**
	 * Method is designed to start adventure where left off.
	 * @return String 
	 * @see Room
	 */
	public String run() {
//		return list.rooms.get(index).enterRoom();
		return null;
	}

}
