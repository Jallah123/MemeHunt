package Unit;

import Model.GameUnit;

public class NyanUnit extends GameUnit {
	public NyanUnit(){
		imageUrl = "assets/nyancat.png";
		width = 48;
		height = 48;
	}
	
	public GameUnit copy(){
		return new NyanUnit();
	}
}
