package Model;

public class AliveState implements GameUnitState {

	@Override
	public void doAction(GameUnit u) {
		u.moveBehaviour.move(u.aliveTime);
		u.aliveTime++;
	}

	@Override
	public boolean isDead() {
		return false;
	}
}
