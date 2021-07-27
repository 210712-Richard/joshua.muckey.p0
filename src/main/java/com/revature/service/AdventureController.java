package com.revature.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.users.User;

import io.javalin.http.Context;

public class AdventureController {
	
	private static Logger log = LogManager.getLogger(AdventureController.class);
	private AdventureService as = null;
	
	public AdventureController() {
	}
	public void startAdventure(Context ctx) {
		String username = ctx.pathParam("username");
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		// if we aren't logged in or our username is different than the logged in username
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			return;
		}
		as = new AdventureService(loggedUser.getAdventureFileName(), loggedUser.getUsername());
		
		ctx.result(as.start());
		
	}
	
	public void takeAction(Context ctx) {
		String username = ctx.pathParam("username");
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		// if we aren't logged in or our username is different than the logged in username
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			return;
		}
		if(as == null) {
			ctx.status(403);
			return;
		}
		String num = ctx.pathParam("num", String.class).getOrNull();
		ctx.result(as.update(num));
	}
}
