import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class InputTest extends JFrame{
	boolean alive = true;
	ScreenManager screenManager;
	Input input;
	Sprite sprite;
	Image testScreen = loadImage("images/Test.png");
	Image beach = loadImage("images/boich.jpg");
	int mouseX = 0;
	int mouseY = 0;
	int size = 24;
	String typed = "";
	Robot robot;
	int centerX;
	int centerY;
	boolean gamePaused = false;

	protected Actions jump;
	protected Actions exit;
	protected Actions moveLeft;
	protected Actions moveRight;
	protected Actions pause;

	private Player player;

	// Trick i 100% didnt have to google to get a blank cursor
	Cursor antiCursor = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(""),
			new Point(0, 0), "invisible");

	private DisplayMode allowedModes[] = { new DisplayMode(1920, 1080, 32, 144), new DisplayMode(1920, 1080, 32, 60),
			new DisplayMode(1280, 720, 32, 60) };

	public static void main(String[] args) {
		// Init Display
		InputTest screen = new InputTest();
		screen.run();
	}// main

	public void stop() {
		alive = false;
	}

	public void run() {
		screenManager = new ScreenManager();
		try {
			DisplayMode displayMode = screenManager.findFirstCompatibleMode(allowedModes);
			screenManager.setFullScreen(displayMode);
			Window window = screenManager.getFullScreenWindow();
			input = new Input(window);
			window.setCursor(antiCursor);
			try {
				robot = new Robot();
				mouseX = centerX;
				mouseY = centerY;
			} catch (AWTException ex) {
				System.err.println("lmao robots");
			}
			makeActions();
			makeSprites();
			mainLoop();
		} finally {
			screenManager.restoreScreen();
		}
	}// run

	public boolean isGamePaused() {
		return gamePaused;
	}

	public void setPaused(boolean p) {
		if (gamePaused != p) {
			this.gamePaused = p;
			input.resetAllActions();
		}
	}

	public void init() {

	}

	public void makeSprites() {
		
		Animate playerAnim = new Animate();
		Image square1 = loadImage("images/square/square1.png");
		Image square2 = loadImage("images/square/square2.png");
		Image square3 = loadImage("images/square/square3.png");
		Image square4 = loadImage("images/square/square4.png");
		Image square5 = loadImage("images/square/square5.png");
		
		playerAnim.addFrame(square1, 100);
		playerAnim.addFrame(square2, 100);
		playerAnim.addFrame(square3, 100);
		playerAnim.addFrame(square2, 100);
		playerAnim.addFrame(square1, 100);
		playerAnim.addFrame(square4, 100);
		playerAnim.addFrame(square5, 100);
		playerAnim.addFrame(square4, 100);

		player = new Player(playerAnim);
		player.setFloorY(screenManager.getHeight() - player.getHeight());
	}

	public Image loadImage(String file) {
		return new ImageIcon(file).getImage();
	}

	public void mainLoop() {
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;

		while (alive) {
			long timePassed = System.currentTimeMillis() - currentTime;
			currentTime += timePassed;

			update(timePassed);

			Graphics2D g = screenManager.getGraphics();
			draw(g);
			g.dispose();
			screenManager.update();
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void update(long elapsedTime) {
		checkSystemInput();

		if (!isGamePaused()) {
			checkGameInput();
			player.update(elapsedTime);
		}
	}

	public void checkSystemInput() {
		if (pause.isPressed()) {
			setPaused(!isGamePaused());

		}
		if (exit.isPressed()) {
			stop();
		}
	}

	public void checkGameInput() {
		float DX = 0;
		if (moveLeft.isPressed()) {
			DX -= Player.SPEED;
		}
		if (moveRight.isPressed()) {
			DX += Player.SPEED;
		}
		player.setDX(DX);
		if (jump.isPressed() && player.getPlayerState() != Player.PLAYER_JUMPING) {
			player.jump();
		}
	}

	public void makeActions() {
		jump = new Actions("jump", Actions.firstPressOnly);
		exit = new Actions("exit", Actions.firstPressOnly);
		pause = new Actions("pause", Actions.firstPressOnly);
		moveLeft = new Actions("moveLeft");
		moveRight = new Actions("moveRight");
		
		//Map Keys
		input.mapToKey(exit, KeyEvent.VK_ESCAPE);
		input.mapToKey(pause, KeyEvent.VK_P);
		
		input.mapToKey(jump, KeyEvent.VK_SPACE);
		
		input.mapToKey(moveLeft, KeyEvent.VK_LEFT);
		input.mapToKey(moveRight, KeyEvent.VK_RIGHT);
		input.mapToKey(moveLeft, KeyEvent.VK_A);
		input.mapToKey(moveRight, KeyEvent.VK_D);
		
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(testScreen, 0, 0, null);
		g.drawImage(player.getImage(), Math.round(player.getX()), Math.round(player.getY()), null);
	}

}
