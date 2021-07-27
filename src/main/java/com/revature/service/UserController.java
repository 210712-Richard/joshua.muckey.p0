package com.revature.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.users.User;
import com.revature.users.UserType;

import io.javalin.http.Context;


public class UserController {

	private static Logger log = LogManager.getLogger(UserController.class);
	private UserService us = new UserService();
	
	public void login(Context ctx) {
		System.out.println("called");
		log.trace("Login method called");
		log.debug(ctx.body());
		
		User u = ctx.bodyAsClass(User.class);
		log.debug(u);

		u = us.login(u);
		log.debug(u);

		if(u != null) {
			ctx.sessionAttribute("loggedUser", u);
			
			ctx.json(u);
			return;
		}

		ctx.status(401);
	}
	
	public void logout(Context ctx) {
		log.debug("logout!");
		ctx.result("Goodbye! " + ((User)ctx.sessionAttribute("loggedUser")).getUsername());
		ctx.req.getSession().invalidate();

	}
	
	public void register(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		User newUser = us.register(u);
		if(newUser != null) {
			ctx.status(201);
			ctx.json(newUser);
		} else {
			ctx.status(409);
			ctx.html("Username already taken.");
		}
		
	}
	
	public void modifyUser(Context ctx) {
		log.debug("modifying");
		if(!validation(ctx))
			return;
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		if(loggedUser.getType().equals(UserType.ADMIN)) {
			String id = ctx.pathParam("id");
			User u = ctx.bodyAsClass(User.class);
			User newUser = us.update(id, u);
			ctx.json(newUser);
			log.debug(newUser);
		}else {
			ctx.status(401);
			ctx.html("Not Admin");
		}
	}
	public void getUsers(Context ctx) {
		
		if(!validation(ctx)) {
			ctx.status(403);
			return;
		}
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		if(loggedUser.getType().equals(UserType.ADMIN)) {
			String predicate = ctx.pathParam("predicate", String.class).getOrNull();
			if(predicate.equals("all"))
				predicate = "";
			List<User> users = us.adminRequest(predicate);
			ctx.json(users);
			log.debug(users);
		}else {
			ctx.status(401);
			ctx.html("Not Admin");
		}
	}
	
	private boolean validation(Context ctx) {
		String username = ctx.pathParam("username");
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			return false;
		}
		return true;
	}
}
