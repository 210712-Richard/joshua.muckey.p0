package com.revature.adventure;

import java.io.Serializable;
import java.util.LinkedList;

public class Adventure implements Serializable{
	
	/**
	 * Controls adventure data
	 */
	private static final long serialVersionUID = 5530775947993281960L;
	private AdventureList list;
	private int index;

	private class AdventureList implements Serializable{
		/**
		 * Wrapper of Data for easy storage
		 */
		private static final long serialVersionUID = -2919344589691125636L;
		private LinkedList<Room> rooms = new LinkedList<Room>();
		
	}
	
	public String run() {
//		return list.rooms.get(index).enterRoom();
		return null;
	}

}
