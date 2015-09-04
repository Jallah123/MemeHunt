package Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import Model.GameUnit;

public class UnitFactory {
	private static final Map<String, GameUnit> units;
	private static final ServiceLoader<GameUnit> loader;
	
	static {
		units = new HashMap<String, GameUnit>();
		loader = ServiceLoader.load(GameUnit.class);
		
		for (GameUnit command : loader) {
			units.put(command.getClass().getSimpleName(), command);
		}
	}
	
	public static final GameUnit create(final String name) {
		if (units.containsKey(name)) {
			return units.get(name).copy();
		}
		
		final String message = String.format("GameUnit '%s' was not found, is the services file up to date?", name);
		throw new IllegalArgumentException(message);
	}
}
