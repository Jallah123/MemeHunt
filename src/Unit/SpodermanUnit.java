package Unit;

import Model.GameUnit;

public class SpodermanUnit extends GameUnit{
	public SpodermanUnit(){
		imageUrl = "assets/spoderman.png";
		width = 48;
		height = 48;
	}
	
	public GameUnit copy(){
		return new SpodermanUnit();
	}
}
