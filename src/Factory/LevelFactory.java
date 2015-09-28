package Factory;

import Level.*;
import Model.Level;

public class LevelFactory {

	private Level currentLevel;

	public LevelFactory() {
		currentLevel = new LevelOne();
		Level level2 = new LevelTwo();
		level2.setNextLevel(new GameOver());
		currentLevel.setNextLevel(level2);
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public Level nextLevel() {
		currentLevel = currentLevel.getNextLevel();
		return currentLevel;
	}

}
