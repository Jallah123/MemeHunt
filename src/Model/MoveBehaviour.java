package Model;

import java.awt.Point;
import java.util.Random;

public abstract class MoveBehaviour {
	
	protected Point position;
	protected Point heading;
	
	public MoveBehaviour(){
		heading = new Point(1, 0);
		Random r = new Random();
		// only spawn in the middle of the screen so it doesn't move out too fast
		position = new Point(r.nextInt(1000), r.nextInt(500));
	}
	
	public abstract void move(int ticksAlive);
	public abstract MoveBehaviour copy();
}
