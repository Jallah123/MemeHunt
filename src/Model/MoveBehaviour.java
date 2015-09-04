package Model;

import java.awt.Point;

public abstract class MoveBehaviour {
	
	private Point heading;
	
	public MoveBehaviour(){
		heading = new Point(1, 0);
	}
	
	public Point move(Point p, int timeAlive){
		heading.y = (int) (Math.cos(timeAlive/3)*10);
		Point newLoc = new Point();
		newLoc.x = p.x + heading.x;
		newLoc.y = p.y + heading.y;
		return newLoc;
	}
}
