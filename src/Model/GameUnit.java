package Model;

import java.awt.Point;
import Factory.MoveBehaviourFactory;

public abstract class GameUnit {
	
	protected MoveBehaviour moveBehaviour;
	protected MoveContainer moveContainer;
	protected int aliveTime;
	protected String imageUrl;
	protected int width;
	protected int height;
	protected int score;
	
	public GameUnit(){
		this.moveContainer = MoveContainer.getInstance();
		moveBehaviour = MoveBehaviourFactory.create();
		moveContainer.add(moveBehaviour);
		aliveTime = 0;
		score = 1;
	}
	
	public abstract GameUnit copy();
	
	public void update(){
		moveBehaviour.move(aliveTime);
		aliveTime++;
	}
	
	public int getScore() {
		return score;
	}
	public Point getPosition() {
		return moveBehaviour.position;
	}
	public int getAliveTime() {
		return aliveTime;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
