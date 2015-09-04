package Unit;

import Model.GameUnit;

public class SanicUnit extends GameUnit {
	public SanicUnit(){
		imageUrl = "assets/sanic.png";
		width = 48;
		height = 48;
	}
	
	public GameUnit copy(){
		return new SanicUnit();
	}
}
