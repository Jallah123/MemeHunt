package Model;

import java.awt.Point;
import java.util.Random;

public abstract class GameUnit extends MoveBehaviour {
	
	protected int aliveTime;
	protected String imageUrl;
	protected Point position;
	protected int width;
	protected int height;
	protected int score;
	
	
	public GameUnit(){
		Random r = new Random();
		// only spawn in the middle of the screen so it doesn't move out too fast
		position = new Point(r.nextInt(1000), r.nextInt(500));
		aliveTime = 0;
		score = 1;
	}
	
	public abstract GameUnit copy();
	
	public void update(){
		position = move(position, aliveTime);
		aliveTime++;
	}
	
	public int getScore() {
		return score;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
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
