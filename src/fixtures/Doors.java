package fixtures;

import fixtures.Room;

public class Doors extends Fixture {

	Room[] adjoiningRooms = new Room[2];
	
	public Doors(String name, String shortDecrption, String longDescription, Room room1, Room room2) {
		super(name, shortDecrption, longDescription);
		this.adjoiningRooms[0] = room1;
		this.adjoiningRooms[1] = room2;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setShortDecrption(String s) {
		this.shortDescription = s;
	}
	
	public void setLongDescription(String s) {
		this.longDescription = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Room[] getAdjoiningRooms() {
		return this.adjoiningRooms;
	}
}
