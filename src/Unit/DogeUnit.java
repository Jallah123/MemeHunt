package Unit;

import Model.GameUnit;

public class DogeUnit extends GameUnit {
	public DogeUnit(){
		imageUrl = "assets/doge.png";
		width = 48;
		height = 48;
	}
	
	public GameUnit copy(){
		return new DogeUnit();
	}
}
