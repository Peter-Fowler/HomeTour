package game;

import fixtures.Room;

public class Player {

	String name = "Ready";
	Room currentRoom; // the room the player is currently in
	boolean want2Stay = true;
	
	public boolean isWant2Stay() {
		return want2Stay;
	}

	public void setWant2Stay(boolean want2Stay) {
		this.want2Stay = want2Stay;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

}
