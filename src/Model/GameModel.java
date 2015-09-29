package Model;

import java.util.ArrayList;

public class GameModel {

	private ArrayList<GameUnit> gameUnits;
	private MoveContainer moveContainer;
	private Level level;
	private int score;
	private int fps;

	public GameModel() {
		gameUnits = new ArrayList<GameUnit>();
		moveContainer = MoveContainer.getInstance();
		score = 0;
	}

	public boolean allDead() {
		int deadCount = 0;
		for (GameUnit gu : gameUnits) {
			if (gu.isDead()) {
				deadCount++;
			}
		}
		if (deadCount == gameUnits.size()) {
			return true;
		}
		return false;
	}

	public void addScore(int i) {
		score += i;
	}

	public int getScore() {
		return score;
	}

	public void addGameUnit(GameUnit gu) {
		gameUnits.add(gu);
	}

	public ArrayList<GameUnit> getGameUnits() {
		return gameUnits;
	}

	public MoveContainer getMoveContainer() {
		return moveContainer;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getFps() {
		return fps;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
