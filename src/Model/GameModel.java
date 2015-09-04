package Model;

import java.util.ArrayList;

public class GameModel {
	
	private ArrayList<GameUnit> gameUnits;
	private int score;
	
	public GameModel(){
		gameUnits = new ArrayList<GameUnit>();
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
}
