package Factory;

import java.util.ArrayList;
import java.util.Random;
import java.util.ServiceLoader;
import Model.GameUnit;

public class UnitFactory {
	private static final ArrayList<GameUnit> units;
	private static final ServiceLoader<GameUnit> loader;
	
	static {
		units = new ArrayList<GameUnit>();
		loader = ServiceLoader.load(GameUnit.class);
		
		for (GameUnit command : loader) {
			units.add(command);
		}
	}
	
	public static final GameUnit createUnit() {
		Random r = new Random();
		return units.get(r.nextInt(units.size())).copy();
	}
}