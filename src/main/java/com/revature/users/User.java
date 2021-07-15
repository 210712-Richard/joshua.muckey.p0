package com.revature.users;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2410782848277166301L;
	private String username;
	private String adventureFileName;
	private UserType type;
	
	public User(String username) {
		super();
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
	
	
	
}
