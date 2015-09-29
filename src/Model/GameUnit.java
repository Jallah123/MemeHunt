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
	protected GameUnitState state;

	public GameUnit() {
		this.moveContainer = MoveContainer.getInstance();
		moveBehaviour = MoveBehaviourFactory.create();
		moveContainer.add(moveBehaviour);
		aliveTime = 0;
		score = 10;
		state = new AliveState();
	}

	public abstract GameUnit copy();

	public void update() {
		state.doAction(this);
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

	public GameUnitState getState() {
		return state;
	}

	public void setState(GameUnitState state) {
		this.state = state;
	}
	public boolean isDead(){
		return this.state.isDead();
	}
}
