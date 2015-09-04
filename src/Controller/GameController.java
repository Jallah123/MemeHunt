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
/*		gameModel.addGameUnit(new DogeUnit());
		gameModel.addGameUnit(new SanicUnit());
		gameModel.addGameUnit(new NyanUnit());
		gameModel.addGameUnit(new DolanUnit());
		gameModel.addGameUnit(new SpodermanUnit());
		*/
		gameModel.addGameUnit(UnitFactory.create("DogeUnit"));
		
		inputContainer = new InputContainer();
		gameView = new GameView(gameModel);
		gameView.getPlayingField().addMouseListener(inputContainer);
		play();
	}

	public void play() {
		while (playing) {
			while (!inputContainer.getInputs().empty()) {
				MouseEvent e = inputContainer.getInputs().pop();
				handleMouseEvent(e);
			}
			ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
			for (GameUnit gu : gameModel.getGameUnits()) {
				gu.update();
				if(isOutOfScreen(gu)){
					unitsToRemove.add(gu);
				}
			}
			gameModel.getGameUnits().removeAll(unitsToRemove);
			gameView.getPlayingField().repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("System woke up");
			}
		}
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
	
	public void handleMouseEvent(MouseEvent e) {
		ArrayList<GameUnit> unitsToRemove = new ArrayList<GameUnit>();
		for (GameUnit gu : gameModel.getGameUnits()) {
			Rectangle unit = new Rectangle(gu.getPosition().x,
					gu.getPosition().y, gu.getWidth(), gu.getHeight());
			if (unit.intersects(new Rectangle(e.getX(), e.getY(), 2, 2))) {
				unitsToRemove.add(gu);
			}
		}
		gameModel.getGameUnits().removeAll(unitsToRemove);
	}
}
