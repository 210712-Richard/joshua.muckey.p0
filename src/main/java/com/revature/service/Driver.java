package com.revature.service;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Javalin app = Javalin.create().start(8080);
		
		UserController uc = new UserController();
		AdventureController ac = new AdventureController();
		
		app.get("/", (ctx)->ctx.html("Hello World"));
		
		app.post("/users", uc::login);
		
		app.delete("/users", uc::logout);
		
		app.put("/users/:username", uc::register);
		
		app.patch("/users/:username/:id", uc::modifyUser);
		
		app.get("/users/:username/users/:predicate", uc::getUsers);

		app.get("/users/:username/adventure", ac::startAdventure);
		
		app.post("/users/:username/adventure/restart", ac::restartAdventure);
		
		app.patch("/users/:username/adventure/:num", ac::takeAction);
		
		
	}
}
