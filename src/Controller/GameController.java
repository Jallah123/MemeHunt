package Controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Factory.LevelFactory;
import Factory.UnitFactory;
import Model.DeadState;
import Model.GameModel;
import Model.GameUnit;
import Model.InputContainer;
import Model.Level;
import View.GameView;

public class GameController {

	private GameModel gameModel;
	private GameView gameView;
	private InputContainer inputContainer;
	private boolean playing;
	private long previousTick;
	private long previousFpsUpdate;
	private int fps;
	private LevelFactory levelFactory;

	public GameController() {
		playing = true;
		levelFactory = new LevelFactory();
		gameModel = new GameModel();
		gameModel.setLevel(levelFactory.getCurrentLevel());
		inputContainer = new InputContainer();
		gameView = new GameView(gameModel);
		gameView.getPlayingField().addMouseListener(inputContainer);
		play();
	}

	public void play() {
		previousTick = System.currentTimeMillis();
		while (playing) {
			long dt = System.currentTimeMillis() - previousTick + 1;
			if (dt > gameModel.getLevel().getSpeed()) {
				handleMouseEvents();
				update();
				removeOutOfScreenUnits();
				spawnUnit(dt);
				previousTick = System.currentTimeMillis();
				nextLevel();
			}
			updateFPS(dt);
			gameView.getPlayingField().repaint();

		}
	}
	
	private void updateFPS(long delta) {
	    if (previousFpsUpdate > 1000) {
	        gameModel.setFps(fps);
	        fps = 0;
	        previousFpsUpdate = 0;
	    }
	    previousFpsUpdate += delta;
	    fps++;
	}

	private void nextLevel() {
		if (gameModel.getLevel().getAmountOfEnemies() <= 0 && gameModel.allDead()) {
			Level nextLevel = levelFactory.nextLevel();
			if (nextLevel != null) {
				gameModel.setLevel(nextLevel);
			}
		}
	}

	private void spawnUnit(long dt) {
		Level level = gameModel.getLevel();
		level.setTimeTillSpawn(level.getTimeTillSpawn() - dt);
		if (level.getTimeTillSpawn() <= 0 && level.getAmountOfEnemies() > 0) {
			gameModel.addGameUnit(UnitFactory.createUnit());
			level.setTimeTillSpawn(level.getSpawnTime());
			level.setAmountOfEnemies(level.getAmountOfEnemies() - 1);
		}
	}

	private void update() {
		for (GameUnit gu : gameModel.getGameUnits()) {
			gu.update();
		}
	}

	private void removeOutOfScreenUnits() {
		ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
		for (GameUnit gu : gameModel.getGameUnits()) {
			if (isOutOfScreen(gu)) {
				unitsToRemove.add(gu);
			}
		}
		setDeadState(unitsToRemove);
	}

	private boolean isOutOfScreen(GameUnit gu) {
		if (gu.getPosition().x < 0 || gu.getPosition().x > gameView.getPlayingField().getWidth()) {
			return true;
		}
		if (gu.getPosition().y < 0 || gu.getPosition().y > gameView.getPlayingField().getHeight()) {
			return true;
		}
		return false;
	}

	private void handleMouseEvents() {
		while (!inputContainer.getInputs().empty()) {
			MouseEvent e = inputContainer.getInputs().pop();
			handleMouseEvent(e);
		}
	}

	private void handleMouseEvent(MouseEvent e) {
		ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
		for (GameUnit gu : gameModel.getGameUnits()) {
			Rectangle unit = new Rectangle(gu.getPosition().x, gu.getPosition().y, gu.getWidth(), gu.getHeight());
			if (unit.intersects(new Rectangle(e.getX(), e.getY(), 2, 2))) {
				unitsToRemove.add(gu);
				gameModel.addScore(gu.getScore());
			}
		}
		setDeadState(unitsToRemove);
	}

	private void setDeadState(ArrayList<GameUnit> units) {
		for (GameUnit u : units) {
			u.setState(new DeadState());
		}
	}
}
