package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Doors;
import fixtures.Room;

public class RoomManager {

	Room startingRoom;
	
	Room nextRoom;
	
	Room[] rooms;
	
	Doors[] allDoors;
	
	public void init() {

		Room frontPorch = new Room("Front Porch", "The Front Porch.",
				"This would be a nice place for some rocking chairs.");
		Room livingRoom = new Room("Living room", "The living room.",
				"There is a fireplace in the East wall and a window looking onto the porch in the South wall.");
		Room bonusRoom = new Room("Bonus room", "A small extra room.", "There is a window in the South "
				+ "wall that looks onto the front porch.\n A closet sticks out of the East Wall.");
		Room bedroom = new Room("Bedroom", "The bedroom",
				"There is a window in the West wall and two closets coming out of the North wall.");
		Room bathroom = new Room("Bathroom", "A small bathroom.","The tub/shower takes up the entire North "
						+ "side of the room with a window that overlooks the rear porch.\nThere is a sink is in the "
						+ "South-East corner with the toilet in between the tub and sink on the East wall.");
		Room kitchen = new Room("Kitchen", "The kitchen", "There is a double basin sink on the North connected "
						+ "to a \ncounter to its left and a window about the sink. The counter \nconnects to the "
						+ "range on the West wall and continues to make \na bar section that acts as the South "
						+ "wall. There is also a \npantry, a washer/dryer combo, and a refrigerator on the East \n"
						+ "wall in that order.");
		Room rearPorch = new Room("Rear Porch", "The rear porch", "There are two windows in the South wall, one "
				+ "looking into \nthe kitchen and one looking into the bathroom.");
		Room screenedPorch = new Room("Screened in Porch", "A small screened in porch",
				"About one third the size of the front porch and shares the back \nwith the rear porch.");
		
		this.startingRoom = frontPorch;

		rooms = new Room[] { frontPorch, livingRoom, bonusRoom, bedroom, bathroom, kitchen, rearPorch,
				screenedPorch };
		
		
		frontPorch.setExits("Living Room", livingRoom);
		livingRoom.setExits("Front Porch", frontPorch);
		livingRoom.setExits("Bonus Room", bonusRoom);
		livingRoom.setExits("Bedroom", bedroom);
		livingRoom.setExits("Bathroom", bathroom);
		livingRoom.setExits("kitchen", kitchen);
		bonusRoom.setExits("Living", livingRoom);
		bedroom.setExits("Bathroom", bathroom);
		bedroom.setExits("Screened Porch", screenedPorch);
		bedroom.setExits("Living Room", livingRoom);						
		bathroom.setExits("Bedroom", bedroom);
		bathroom.setExits("Living Room", livingRoom);
		kitchen.setExits("Living Room", livingRoom);
		kitchen.setExits("Rear Porch", rearPorch);
		rearPorch.setExits("Kitchen", kitchen);
		rearPorch.setExits("Screened Proch", screenedPorch);
		screenedPorch.setExits("Bedroom", bedroom);
		screenedPorch.setExits("Rear Porch", rearPorch);
		
		

		Doors frontDoor = new Doors("Front Door", "The front door", "", frontPorch, livingRoom);
		Doors bonusDoor = new Doors("Bonus room door", "The bonus room door", "", livingRoom, bonusRoom);
		Doors bedroomDoor = new Doors("Bedroom door", "The bedroom door", "", livingRoom, bedroom);
		Doors bathroomDoor = new Doors("Bathroom door", "The bathroom door", "", livingRoom, bathroom);
		Doors kitchenDoor = new Doors("Kitchen entrence", "The kitchen entrence", "", livingRoom, kitchen);
		Doors rearDoor = new Doors("Rear door", "The back door", "", kitchen, rearPorch);
		Doors screenedDoor = new Doors ("Screen Door", "A screen door", "", rearPorch, screenedPorch);
		Doors bed2ScreenDoor = new Doors("Bedroom door", "The bedroom door to the screened porch", "", bedroom, screenedPorch);
		Doors bed2BathDoor = new Doors("Bathroom door", "Door between the bedroom and the bathroom", "", bedroom, bathroom);
		
		allDoors = new Doors[] {frontDoor, bonusDoor, bedroomDoor, bathroomDoor, kitchenDoor, rearDoor, screenedDoor, bed2ScreenDoor, bed2BathDoor};
		
	}

	public Room getSartingRoom() {
		return startingRoom;
	}
	/*
	 * command[] contains the user input which should hold a location...
	 * could not get the key part of the map to work with me...
	 *
	public void moveRooms(String[] command, Player player) {
		Map<String, Room> leave = new HashMap<String, Room>();
		leave = player.currentRoom.getExits();
		
		outer: for (int i = 1; i < command.length; i++) {
			if (command[i].equalsIgnoreCase("room")) {
				break;
			}
			
			for(String key : leave.keySet()) {
				
				System.out.println("This is the key: " + key.toString());
				System.out.println("This is the command: " + command[i]);
				
				String[] temp = leave.keySet().toString().split(" ");
				
				for (int j = 0; j < temp.length; j++) {
					temp[j] = keepLetters(temp[j]);
			}
				String tempWords = "Front Porch";
				
				for (int j = 0; j < temp.length; j++) {
					System.out.println("This is the temp: " + temp[j]);
				if (command[i].equalsIgnoreCase(temp[j].toString())){
					System.out.println("Match found: " + command[i] + " : " + temp[j]);
					if (j < temp.length - 1) {
						tempWords = combineStrings(temp);
						System.out.println("this is the tempWords:" + tempWords);
					}
					System.out.println("the key to leave when leaving is: " +leave.get(tempWords));
					
					player.currentRoom = leave.get(tempWords);
					break outer;
				}
			}
		}
		}
	}

	 		*/ // someday I'll figure map keys out, but not today...
	
	public void moveRoomThroughDoor(String[] command, Player player) {
		
		Doors[] allDoors = getAllDoors();
		
		String tempWords = "Front Porch";
		
		tempWords = combineStrings(command);
		
		for (int i = 0; i < allDoors.length; i++) {
			
			Room[] tempDoor = allDoors[i].getAdjoiningRooms();
			
			for (int j = 0; j < 2; j++) {
				System.out.println("the tempDoor: " + tempDoor[j] + "\nthe currentRoom: " + player.currentRoom.getName());
				if (tempDoor[j].getName().equalsIgnoreCase(player.currentRoom.getName())) {
					
					for (int d = 0; d < 2; d++) {
						if (tempDoor[d].getName().equalsIgnoreCase(tempWords)){
							
							player.currentRoom = tempDoor[d];
						}
					}
				
				}
			}
		}
		
	}
	
	public Doors[] getAllDoors() {
		
		return this.allDoors;
	}

	private String combineStrings(String[] temp) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < temp.length; i++) {
			sb.append(temp[i] + " ");
			
		}
		
		String s = sb.toString();
		
		return s;
	}

	private String keepLetters(String temp) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z' || temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z') {
				sb.append(temp.charAt(i));
			}
		}
		String s = sb.toString();
		System.out.println("The keepLetters string: " + s);
		
		return s;
	}
	
	
	 
}
