public class MoveForward {

	// Function returns true if matrix[i][j] is a valid index
	public static boolean isValid(int i, int j, int rows, int columns) {
		if(i < rows && i >=0 && j >= 0 && j < columns) {
			return true;
		}
		return false;
	}
	
	// This method will execute different methods on the basis of different cases like 'L','M' and 'R'
	public static Robot executeInstruction(int i, int j, int rows, int columns, String direction, String robotInstructions) {
		//System.out.println("robotInstructions -- " + robotInstructions);
		char inst[] = robotInstructions.toCharArray();
		String updatedDirection = direction;
		Robot robotPosition = null;
		System.out.println("Input is -> (" + i + ","+ j + ") " + direction);
		for(int x=0;x<inst.length;x++) {
			if(inst[x] == 'L') {
				updatedDirection = TurnLeftRight.turnLeft(updatedDirection);
			}else if(inst[x] == 'R') {
				updatedDirection = TurnLeftRight.turnRight(updatedDirection);
			}else {
				robotPosition = moveAhead(i,j,updatedDirection);
				i = robotPosition.getX();
				j = robotPosition.getY();
			}
		}
		robotPosition.setDirection(updatedDirection);
		robotPosition.setInstructions(robotInstructions);
		return robotPosition;
	}
	
	// This method deals with the case when 'M' comes in robot instructions.
	// For the east direction, we'll increment the value in x axis.
	// For the west direction, we'll decrement the value in x axis.
	// For the north direction, we'll increment the value in y axis.
	// For the south direction, we'll decrement the value in y axis.
	public static Robot moveAhead(int i,int j, String direction) {
		//System.out.println("Initial point is (" + i + "," + j+") " + direction);
		switch (direction) {
			case "E":
				i++;
				break;
			case "W":
				i--;
				break;
			case "N":
				j++;
				break;
			case "S":
				j--;
				break;
		}
		//System.out.println("Return point is (" + i + "," + j+")");
		return new Robot(i, j);
 }
	
}
