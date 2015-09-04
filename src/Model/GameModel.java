package Model;

import java.util.ArrayList;

public class GameModel {
	
	private ArrayList<GameUnit> gameUnits;
	
	public GameModel(){
		gameUnits = new ArrayList<GameUnit>();
	}
	
	public void addGameUnit(GameUnit gu){
		gameUnits.add(gu);
	}
	
	public ArrayList<GameUnit> getGameUnits(){
		return gameUnits;
	}
}
