// Robot class has details of robot like x coordinate, y coordinate, 
// current direction and instructions which robot has to follow.
public class Robot {

	private int x;
	private int y;
	private String direction;
	private String instructions;
	
	public Robot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Robot(int x, int y, String direction, String instructions) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.instructions = instructions;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", direction=" + direction + ", instructions=" + instructions + "]";
	}

	// Equals method is used to check if two robots collides(comes at the same point)
    @Override
    public boolean equals(Object obj)
    {
    	if(this == obj)
            return true;
   
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        Robot robotObject = (Robot) obj;
        return (robotObject.x == this.x && robotObject.y == this.y && robotObject.direction.equals(this.direction));
    }
}
