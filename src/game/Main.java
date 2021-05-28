package game;

import java.util.HashMap;
import java.util.Map;
import fixtures.Room;
import java.util.Scanner;

public class Main {

	static String[] ready;
	static RoomManager rm = new RoomManager();
	
	public static void main(String[] args) {
		
		Map<String, Room> leave = new HashMap<String, Room>();
		rm.init();
		Scanner input = new Scanner(System.in);
		
//		System.out.println(rm.startingRoom.toString());
		
		Player p1 = new Player();
		
		
		  p1.setCurrentRoom(rm.startingRoom);
		 /* 
		 * printRoom(p1);
		 * 
		 * System.out.println(p1.currentRoom);
		 * 
		 * System.out.println(rm.rooms[0].getExits());
		 */
		
		System.out.println("Ready arives at a house for a look around.\n");
	
		do {
			printRoom(p1);
			
			leave = p1.currentRoom.getExits();
			
			System.out.println("Ready can \'go\' into the:");
			
			for(String s : leave.keySet()) {
				System.out.println(s);
			}
			System.out.println("Or Ready can \'leave\' the house");
			
			collectInput(input);
			try {
			parse(ready, p1);
			}catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println("The floor beneath Ready opens up and swallows him whole!");
			}
			
		}while (p1.want2Stay);
	
		input.close();
	
		System.out.println("Ready leaves the house.");
	}
	
	private static void printRoom(Player player) {

		String[] youAreHere = new String[3];
		
		youAreHere = player.currentRoom.toFullString();
		
		System.out.println("-   -   -   " + youAreHere[0] + "   -   -   -\n"
				+ youAreHere[2] + "\n\n");
	}

	private static String[] collectInput(Scanner input) {
		ready = input.nextLine().split(" ");
		return ready;
	}
		
	private static void parse(String[] command, Player player) {
		String room1 = player.currentRoom.getName();
		
			switch(command[0].toUpperCase()) {
			default:
				System.out.println("Command unclear.\nTry typing go then a destination.");
				break;
			case "GO":
				rm.moveRooms(command, player);
				if (room1.equalsIgnoreCase(player.currentRoom.getName())) {
					System.out.println("Ready is unsure of what to do...");
				}else {
				System.out.println("Ready walks to the " + player.currentRoom.getName() + ".");
				}
				break;
			case "LEAVE":
				player.want2Stay = false;
				break;
		
		}
	}
}
