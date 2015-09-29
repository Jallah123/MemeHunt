package Model;

public interface GameUnitState {
	public void doAction(GameUnit u);
	public boolean isDead();
}
