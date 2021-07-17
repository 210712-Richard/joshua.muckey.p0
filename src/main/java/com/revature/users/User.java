package com.revature.users;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{

	private static final long serialVersionUID = 2410782848277166301L;
	private Integer id;
	private static int counter = 0;
	private String username;
	private String adventureFileName;
	private UserType type;
	
	public User(String username) {
		super();
		this.id = new Integer(counter++);
		this.username = username;
		this.type = UserType.PLAYER;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdventureFileName() {
		return adventureFileName;
	}

	public void setAdventureFileName(String adventureFileName) {
		this.adventureFileName = adventureFileName;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adventureFileName, id, type, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(adventureFileName, other.adventureFileName) && Objects.equals(id, other.id)
				&& type == other.type && Objects.equals(username, other.username);
	}
	
	
	
}
