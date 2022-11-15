import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RobotWarsEntryPoint {

	public static void main(String[] args) {
		Map<String, String> inputMap = takeInput();
		
		// This block is for the hard coded input for faster testing.
		
//		Map<String, String> inputMap = new HashMap<>();
//		inputMap.put("rows", "5");
//		inputMap.put("columns", "5");
//		inputMap.put("3 3 E", "MMRMMRMRRM");
//		inputMap.put("1 2 N", "LMLMLMLMM");
//		inputMap.put("1 3 N", "LMLMLMLMM");
		
		
		int rows = Integer.parseInt(inputMap.get("rows"));
		int columns = Integer.parseInt(inputMap.get("columns"));
		
		inputMap.remove("rows");
		inputMap.remove("columns");
		
		System.out.println(inputMap);

		List<Robot> allRobotsArray = new ArrayList<>();
		int counter=0;
		for(String key : inputMap.keySet()) {
			String keyArr[] = key.split(" ");
			int robotXCordinate = Integer.parseInt(keyArr[0]);
			int robotYCordinate = Integer.parseInt(keyArr[1]);
			String direction = keyArr[2];
			allRobotsArray.add(new Robot(robotXCordinate, robotYCordinate,direction,inputMap.get(key)));
			counter++;
		}
		
		for(int i=0;i<allRobotsArray.size();i++) {
			//System.out.println(allRobotsArray.toString());
			int robotXCordinate = allRobotsArray.get(i).getX();
			int robotYCordinate = allRobotsArray.get(i).getY();
			String direction = allRobotsArray.get(i).getDirection();
			String instructions = allRobotsArray.get(i).getInstructions();
			boolean isValidCoordinate = MoveForward.isValid(robotXCordinate, robotYCordinate, rows , columns);
			if(isValidCoordinate) {
				Robot resultPoint = MoveForward.executeInstruction(robotXCordinate, robotYCordinate, rows, columns, direction,instructions);
				System.out.println("Results are -> (" + resultPoint.getX() + ","+ resultPoint.getY() + ") " + resultPoint.getDirection());
				int robotCollisionIndex = hasCollision(resultPoint, allRobotsArray);
				if(robotCollisionIndex >= 0) {
					allRobotsArray.remove(robotCollisionIndex);
				}
			}else {
				System.out.println("Input is -> (" + robotXCordinate + ","+ robotYCordinate + ") " + direction);
				System.out.println("Coordinates are invalid. Please provide valid data.");
			}
		}
	}
	
	// This method takes the input from the user
	// 1. Enter matrix rows and columns 5 5
	// 2. Enter num of robots 2
	// 3. Enter robot's position with the direction 1 2 N
	// 4. Enter instructions for the robot LMLMLMLMM
	public static Map<String,String> takeInput() {
		Map<String,String> map = new LinkedHashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter matrix rows and columns");
		
		String rowsAndColumns =scanner.nextLine();		
		String arr[] = rowsAndColumns.split(" ");
		String rows = arr[0];
		String columns = arr[1];
		
		System.out.println("Enter num of robots");
		int numRobots = Integer.parseInt(scanner.nextLine());
		
		while (numRobots-- > 0) {
			System.out.println("Enter robot's position with the direction");
			String robotsPosition = scanner.nextLine();
			//System.out.println("robotsPosition -- " + robotsPosition);
			System.out.println("Enter instructions for the robot");
			String robotsInstructions = scanner.nextLine();
			//System.out.println("robotsInstructions -- " + robotsInstructions);
			map.put(robotsPosition, robotsInstructions);
		}
		scanner.close();
		map.put("rows", rows);
		map.put("columns", columns);
		return map;
	}
	
	// This method returns the index when two robots might collide or two robots might reach to same point.
	public static int hasCollision(Robot p, List<Robot> allRobotsArray) {
		int result = -1;
		for(int i=0;i<allRobotsArray.size();i++) {			
			if(p.equals(allRobotsArray.get(i))) {
				System.out.println(p + " point has collision." );
				result = i;
			}
		}
		return result;
	}
}
