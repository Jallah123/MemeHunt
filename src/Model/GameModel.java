package Model;

import java.util.ArrayList;

public class GameModel {
	
	private ArrayList<GameUnit> gameUnits;
	private MoveContainer moveContainer;
	private int score;
	private int fps;
	
	public GameModel(){
		gameUnits = new ArrayList<GameUnit>();
		moveContainer = MoveContainer.getInstance();
		score = 0;
	}
	
	public void addScore(int i){
		score += i;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addGameUnit(GameUnit gu){
		gameUnits.add(gu);
	}
	
	public ArrayList<GameUnit> getGameUnits(){
		return gameUnits;
	}
	
	public MoveContainer getMoveContainer(){
		return moveContainer;
	}
	
	public void setFps(int fps){
		this.fps = fps;
	}
	
	public int getFps(){
		return fps;
	}
}
