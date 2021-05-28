package fixtures;

public class Doors extends Fixture {

	String[] adjoiningRooms = new String[2];
	
	public Doors(String name, String shortDecrption, String longDescription, String room1, String room2) {
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
	
	public String[] getAdjoiningRooms() {
		return this.adjoiningRooms;
	}
}
