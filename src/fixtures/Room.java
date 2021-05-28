package fixtures;

import java.util.HashMap;
import java.util.Map;

import game.Player;

public class Room extends Fixture{
	
	Map<String, Room> exits = new HashMap<String, Room>(); // The rooms adjacent to this one.
	
	public Room(String name, String shortDecrption, String longDescription) {
		super(name, shortDecrption, longDescription);
	}
	
	public void setExits(String name, Room room) {
		this.exits.put(name, room);
	}
	
	public Map<String, Room> getExits() {
		return exits;
		
	}
	
	public Room getExit(String place) {
		return this.exits.get(place);
		
	}
	
	public String toString() {
		return name;
	}
		
}
