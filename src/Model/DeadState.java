package Model;

public class DeadState implements GameUnitState {

	@Override
	public void doAction(GameUnit u) {

	}

	@Override
	public boolean isDead() {
		return true;
	}
}
