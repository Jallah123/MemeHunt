package Model;

import java.awt.Point;
import java.util.Random;

public abstract class GameUnit extends MoveBehaviour {
	
	protected int aliveTime;
	protected String imageUrl;
	protected Point position;
	protected int width;
	protected int height;
	
	public GameUnit(){
		Random r = new Random();
		position = new Point(r.nextInt(1024), r.nextInt(720));
		aliveTime = 0;
	}
	
	public void update(){
		position = move(position, aliveTime);
		aliveTime++;
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
