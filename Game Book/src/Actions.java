
public class Actions {
	private static int normal = 0;

	private String name;
	private int behaviour;
	int state;
	int amount;

	public static int firstPressOnly = 1;
	public int releasedCode = 0;
	public int pressedCode = 1;
	public int waitReleaseCode = 2;

	public Actions(String name) {
		this(name, normal);
	}

	public Actions(String name, int behavior) {
		this.name = name;
		this.behaviour = behavior;
		reset();
	}

	public String getName() {
		return name;
	}

	public void reset() {
		state = releasedCode;
		amount = 0;
	}

	public synchronized void press() {
		press(1);
	}

	public synchronized void press(int amount) {
		if (state != waitReleaseCode) {
			this.amount += amount;
			state = pressedCode;
		}
	}

	public synchronized void release() {
		state = releasedCode;
	}
	
	public synchronized void tap() {
		press();
		release();
	}
	
	public synchronized boolean isPressed() {
		 return (getAmount() != 0);
	}

	public synchronized int getAmount() {
		int returned = amount;
		if (returned != 0) {
			if (state == releasedCode) {
				amount = 0;
			} else if (behaviour == firstPressOnly) {
				state = waitReleaseCode;
				amount = 0;
			}
		}
		return returned;
	}

}
