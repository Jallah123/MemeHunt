package Controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Factory.UnitFactory;
import Model.*;
import Unit.*;
import View.*;

public class GameController {

	private GameModel gameModel;
	private GameView gameView;
	private InputContainer inputContainer;
	private boolean playing;

	public GameController() {
		playing = true;
		gameModel = new GameModel();
		
		gameModel.addGameUnit(UnitFactory.create("DogeUnit"));
		gameModel.addGameUnit(UnitFactory.create("SanicUnit"));
		gameModel.addGameUnit(UnitFactory.create("DolanUnit"));
		gameModel.addGameUnit(UnitFactory.create("SpodermanUnit"));
		gameModel.addGameUnit(UnitFactory.create("NyanUnit"));
		
		inputContainer = new InputContainer();
		gameView = new GameView(gameModel);
		gameView.getPlayingField().addMouseListener(inputContainer);
		play();
	}

	public void play() {
		while (playing) {
			handleMouseEvents();
			removeOutOfScreenUnits();
			
			gameView.getPlayingField().repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("System woke up");
			}
		}
	}
	
	private void removeOutOfScreenUnits(){
		ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
		for (GameUnit gu : gameModel.getGameUnits()) {
			gu.update();
			if(isOutOfScreen(gu)){
				unitsToRemove.add(gu);
			}
		}
		gameModel.getGameUnits().removeAll(unitsToRemove);
	}
	
	private boolean isOutOfScreen(GameUnit gu){
		if (gu.getPosition().x < 0
				|| gu.getPosition().x > gameView.getPlayingField()
						.getWidth()) {
			return true;
		}
		if (gu.getPosition().y < 0
				|| gu.getPosition().y > gameView.getPlayingField()
						.getHeight()) {
			return true;
		}
		return false;
	}
	
	private void handleMouseEvents(){
		while (!inputContainer.getInputs().empty()) {
			MouseEvent e = inputContainer.getInputs().pop();
			handleMouseEvent(e);
		}
	}
	
	private void handleMouseEvent(MouseEvent e) {
		ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
		for (GameUnit gu : gameModel.getGameUnits()) {
			Rectangle unit = new Rectangle(gu.getPosition().x,
					gu.getPosition().y, gu.getWidth(), gu.getHeight());
			if (unit.intersects(new Rectangle(e.getX(), e.getY(), 2, 2))) {
				unitsToRemove.add(gu);
				gameModel.addScore(gu.getScore());
			}
		}
		gameModel.getGameUnits().removeAll(unitsToRemove);
	}
}
