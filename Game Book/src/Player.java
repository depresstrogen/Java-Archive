
public class Player extends Sprite {
	public static final int PLAYER_NORMAL = 0;
	public static final int PLAYER_JUMPING = 1;

	public static final float SPEED = (float) 0.3;
	public static final float GRAVITY = (float) 0.003;

	int floorY;
	int playerState;

	public Player(Animate anim) {
		super(anim);
		playerState = PLAYER_NORMAL;
	}

	public int getPlayerState() {
		return playerState;
	}

	public void setPlayerState(int state) {
		this.playerState = state;
	}

	public void setFloorY(int floorY) {
		this.floorY = floorY;
		setY(floorY);
	}

	public void jump() {
		setDY(-1);
		playerState = PLAYER_JUMPING;
	}

	public void update(long elapsedTime) {
		// set vertical velocity (gravity effect)
		if (getPlayerState() == PLAYER_JUMPING) {
			setDY(getDY() + GRAVITY * elapsedTime);
		}
		// move player
		super.update(elapsedTime);
		// check if player landed on floor
		if (getPlayerState() == PLAYER_JUMPING && getY() >= floorY) {
			setDY(0);
			setY(floorY);
			setPlayerState(PLAYER_NORMAL);
		}
	}
}
