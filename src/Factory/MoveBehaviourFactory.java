package Factory;

import java.util.ArrayList;
import java.util.Random;
import java.util.ServiceLoader;

import Model.MoveBehaviour;

public class MoveBehaviourFactory {
	
	private static final ArrayList<MoveBehaviour> behaviours;
	private static final ServiceLoader<MoveBehaviour> loader;
	
	static {
		behaviours = new ArrayList<MoveBehaviour>();
		loader = ServiceLoader.load(MoveBehaviour.class);
		
		for (MoveBehaviour command : loader) {
			behaviours.add(command);
		}
	}
	
	public static final MoveBehaviour create() {
		Random r = new Random();
//		int getal = r.nextInt(behaviours.size()-1);
		return behaviours.get(r.nextInt(behaviours.size())).copy();
//		return behaviours.get(0).copy();
	}
}
