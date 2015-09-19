package MoveBehaviour;

import java.awt.Point;

import Model.MoveBehaviour;

public class CosMoveBehaviour extends MoveBehaviour{
	public CosMoveBehaviour(){
		super();
	}
	
	@Override
	public void move(int ticksAlive) {
		heading.y = (int) Math.round((Math.cos(ticksAlive/10)*10));
		Point newLoc = new Point();
		newLoc.x = position.x + heading.x;
		newLoc.y = position.y + heading.y;
		position = newLoc;
	}
	
	@Override
	public MoveBehaviour copy(){
		return new CosMoveBehaviour();
	}
}
