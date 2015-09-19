package Model;

import java.util.ArrayList;

public class MoveContainer {
	
	private static MoveContainer instance;
	private ArrayList<MoveBehaviour> moves;
	
	private MoveContainer(){
		moves = new ArrayList<MoveBehaviour>();
	}

	public void move(int dt){
		for(MoveBehaviour mb: moves){
			mb.move(dt);
		}
	}
	
	public void add(MoveBehaviour mb){
		moves.add(mb);
	}
	
	public void remove(MoveBehaviour mb){
		moves.remove(mb);
	}
	
	public static MoveContainer getInstance(){
		if(instance == null){
			instance = new MoveContainer();
		}
		return instance;
	}
}
