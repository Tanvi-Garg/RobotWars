
public class TurnLeftRight {

//	     N
//		 |
//		 |	
//	W ---------E
//		 |
//		 |
//		 S
	
	// Here 'E' represents East, 'W' represents West, 'N' represents North, 'S' represents South
	// clockwise direction
	public static String turnRight(String direction) {
		switch (direction) {
		case "E":
			return "S";
		case "S":
			return "W";
		case "W":
			return "N";
		case "N":
			return "E";
		}
		return "";
	}
	
	// anti clockwise direction
	public static String turnLeft(String direction) {
		switch (direction) {
		case "E":
			return "N";
		case "S":
			return "E";
		case "W":
			return "S";
		case "N":
			return "W";
		}
		return "";
	}
}
