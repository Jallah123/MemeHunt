package Model;

public abstract class Level {

	private int amountOfEnemies;
	private int speed;
	private String backgroundImageUrl;
	private int spawnTime;
	private long timeTillSpawn;
	private Level nextLevel;

	public Level(int amountOfEnemies, int speed, int spawnTime, String backgroundImageUrl) {
		this.amountOfEnemies = amountOfEnemies;
		this.speed = speed;
		this.spawnTime = spawnTime;
		this.backgroundImageUrl = backgroundImageUrl;
		this.timeTillSpawn = this.spawnTime;
	}

	public int getAmountOfEnemies() {
		return amountOfEnemies;
	}

	public int getSpeed() {
		return speed;
	}

	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}

	public int getSpawnTime() {
		return spawnTime;
	}

	public long getTimeTillSpawn() {
		return timeTillSpawn;
	}

	public void setTimeTillSpawn(long timeTillSpawn) {
		this.timeTillSpawn = timeTillSpawn;
	}

	public void setAmountOfEnemies(int amountOfEnemies) {
		this.amountOfEnemies = amountOfEnemies;
	}

	public Level getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Level nextLevel) {
		this.nextLevel = nextLevel;
	}

}
