package com.revature.adventure;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.UserController;
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
	private Logger log = LogManager.getLogger(Adventure.class);

	/**
	 * Wrapper for easy data storage.
	 * 
	 * @author MuckJosh
	 *
	 */
	public class AdventureList implements Serializable, Observer {

		private Logger log = LogManager.getLogger(AdventureList.class);
		private static final long serialVersionUID = -2919344589691125636L;
		protected LinkedList<Room> rooms = new LinkedList<Room>();
		private Room currentRoom = null;
		private LinkedList<Checkpoint> points = Stream.of(Checkpoint.values()).collect(Collectors.toCollection(LinkedList::new));

		@Override
		public void update(Observable o, Object arg) {
			if(o instanceof InterAction) {
			Checkpoint point = ((InterAction) o).getPoint();
			log.debug(points.pop().equals(point));
			rooms.stream().forEach(c->c.getTakeableActions().stream()
					.filter(p ->p instanceof InterAction)
					.map(p-> (InterAction) p).collect(Collectors.toList()).stream()
					.filter(p -> p.getPoint().equals(points.peek())).findAny().get().setDisplay(true));
			log.debug(points);
			}
		}

		public final LinkedList<Room> getRooms() {
			return rooms;
		}

		protected final void setRooms(LinkedList<Room> rooms) {
			this.rooms = rooms;
		}

		protected final List<Checkpoint> getPoints() {
			return points;
		}

		protected final void setPoints(LinkedList<Checkpoint> points) {
			this.points = points;
		}
	}

	public Adventure(String userAdventureFile, String userName) {
		this.userName = userName;
		load(userName);
	}

	public void save() {
		DataSerializer<AdventureList> ds = new DataSerializer<AdventureList>();
		ds.writeObjectsToFile(list, adventureFolder + userName + ".dat");
	}


	private void load(String file) {

		DataSerializer<AdventureList> ds = new DataSerializer<AdventureList>();
		try {
			list = (AdventureList) ds.readObjectFromFile(adventureFolder + file + ".dat");
		} catch (IOException e) {

			list = createBase();
		}
	}

	/**
	 * Method is designed to start adventure where left off.
	 * 
	 * @return String
	 * @see Room
	 */
	public String run() {
		if (list.currentRoom == null)
			list.currentRoom = list.rooms.get(0);
		return list.currentRoom.enterRoom();
	}

	public String takeAction(Integer x) {
		Room temp = list.currentRoom;
		list.currentRoom = list.currentRoom.getTakeableActions().get(x).perform(list.currentRoom);
		return list.currentRoom.enterRoom();
	}

	private AdventureList createBase() {
		AdventureList list = new AdventureList();
		Room foyer = new NormalRoom("You are in the Foyer with 4 doors and a picture of a person", new MoveAction("west door", Direction.LEFT, false), 
				new MoveAction("North door", Direction.UP, true),
				new MoveAction("South door", Direction.DOWN, true),
				new MoveAction("east Door", Direction.RIGHT, true),
				new MoveAction("Picture", Direction.INNER));
		Room gallery1 = new NormalRoom("You are in a gallery with 4 doors.",new MoveAction("east door", Direction.RIGHT, false), 
				new MoveAction("South door", Direction.DOWN, false),
				new MoveAction("West Door", Direction.LEFT, false));
		Room gallery2 = new NormalRoom("You are in a gallery with 4 doors.",new MoveAction("east door", Direction.RIGHT, false), 
				new MoveAction("North door", Direction.UP, false),
				new MoveAction("South door", Direction.DOWN, false),
				new MoveAction("West Door", Direction.LEFT, false));
		Room great = new NormalRoom("You are in a Great Room with 2 doors.",new MoveAction("west door", Direction.LEFT, true), 
				new MoveAction("South door", Direction.DOWN, false));
		Room maid = new NormalRoom("You are in a maids room with 1 door.", new MoveAction("east door", Direction.RIGHT, false), new InterAction("Grab Cleaning Supplies", Checkpoint.MAID_SUPPLIES));
		Room library = new NormalRoom("You are in a Library with 1 door.", new MoveAction("North door", Direction.UP, false), new MoveAction("Glass Container locked", Direction.INNER, false));
		
		Room mainPicture = new NormalRoom("The picture on the wall is of Marc Blank and Dave Lebling. Creators of Z _ _ _. It appears letters are missing.", new MoveAction("Focus on Foyer",Direction.OUTER),new InterAction("place O", Checkpoint.LETTER_O, false));
		
		Room libGlass = new NormalRoom("A locked glass container, really dirty if you i had some cleaning supplies!", new MoveAction("Back to Library", Direction.OUTER), new InterAction("Clean the glass", Checkpoint.LIBRARY_CLEAN,false));
		foyer.getAdjacentRooms().put(Direction.UP, great);
		foyer.getAdjacentRooms().put(Direction.RIGHT, gallery2);
		foyer.getAdjacentRooms().put(Direction.LEFT, gallery1);
		foyer.getAdjacentRooms().put(Direction.DOWN, new NormalRoom("End \n CONGRATZ!"));
		foyer.getAdjacentRooms().put(Direction.INNER, mainPicture);
		
		gallery1.getAdjacentRooms().put(Direction.RIGHT, foyer);
		gallery1.getAdjacentRooms().put(Direction.DOWN, library);
		gallery1.getAdjacentRooms().put(Direction.LEFT, maid);
		
		gallery2.getAdjacentRooms().put(Direction.LEFT, foyer);
		gallery2.getAdjacentRooms().put(Direction.DOWN, new NormalRoom("kitchen"));
		gallery2.getAdjacentRooms().put(Direction.RIGHT, new NormalRoom("Dinning"));
		gallery2.getAdjacentRooms().put(Direction.UP, new NormalRoom("Family"));
		
		great.getAdjacentRooms().put(Direction.DOWN, foyer);
		
		maid.getAdjacentRooms().put(Direction.RIGHT, gallery1);
		
		library.getAdjacentRooms().put(Direction.UP, gallery1);
		library.getAdjacentRooms().put(Direction.INNER, libGlass);
		
		libGlass.getAdjacentRooms().put(Direction.OUTER, library);
		
		mainPicture.getAdjacentRooms().put(Direction.OUTER, foyer);
		
		list.getRooms().add(foyer);
		list.getRooms().add(gallery1);
		list.getRooms().add(gallery2);
		list.getRooms().add(great);
		list.getRooms().add(maid);
		list.getRooms().add(library);
		list.getRooms().add(libGlass);
		list.getRooms().add(mainPicture);
		log.debug(list.getRooms().stream().peek(room -> room.getTakeableActions()
				.stream().peek(action -> action.addObserver(list))));
				
		
		return list;
		
	}
}
