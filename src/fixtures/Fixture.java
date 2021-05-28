package fixtures;

public abstract class Fixture {
	
	String name; //A short name / title for the fixture
	
	String shortDescription;// A one-sentence-long description of a fixture, used to briefly mention the fixture
	
	String longDescription;// A  paragraph-long description of the thing, displayed when the player 
							//investigates the fixture thoroughly (looks at it, or enters a room)

	public Fixture(String name, String shortDecription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDecription;
		this.longDescription = longDescription;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public String[] toFullString() {
		String[] description= new String[] {this.name, this.shortDescription, this.longDescription};
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}