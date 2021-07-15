# Text Adventure <font size="2">(*Project 0*)</font>
*by Joshua Muckey* <br>
![alt text](https://upload.wikimedia.org/wikipedia/en/thumb/8/86/Colossaladventure.gif/220px-Colossaladventure.gif)
## Introduction
This is a text based adventure based on *Adventure* or any iteration after. I hope you enjoy!

## Design
  Driver :runs game by starting game state.
  * Game State :initializes States needed
    * Menu State :dictates Menu prints
      - Menu : menu strings
    * User State : controls user flow to game state
      - UserBase : controls users
        - User : model
    * Adventure State : controls adventure flow to game state
      - AdventureMap : controls Users adventure
        - Adventure : collection of rooms
          - Room: model

## Status
7/14 - barely off the ground
