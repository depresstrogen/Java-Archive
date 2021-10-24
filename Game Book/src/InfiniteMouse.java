import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class InfiniteMouse extends JFrame
		implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {

	int screenTime = 5000; // Milliseconds
	boolean alive = true;
	ScreenManager screenManager;
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
	int imageX = 0;
	int imageY = 0;
	boolean centering;
	// Trick i 100% didnt have to google to get a blank cursor
	Cursor antiCursor = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(""),
			new Point(0, 0), "invisible");

	private DisplayMode allowedModes[] = { new DisplayMode(1920, 1080, 32, 144), new DisplayMode(1920, 1080, 32, 60),
			new DisplayMode(1280, 720, 32, 60) };

	public static void main(String[] args) {
		// Init Display
		InfiniteMouse screen = new InfiniteMouse();
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
			window.setCursor(antiCursor);
			window.addKeyListener(this);
			window.addMouseListener(this);
			window.addMouseMotionListener(this);
			window.addMouseWheelListener(this);

			try {
				robot = new Robot();
				centerMouse();
				mouseX = centerX;
				mouseY = centerY;
			} catch (AWTException ex) {
				System.err.println("lmao robots");
			}
			loadImages();
			mainLoop();
		} finally {
			screenManager.restoreScreen();
		}
	}// run

	public void init() {

	}

	public void loadImages() {
		Image dvd1 = loadImage("images/DVD/DVD1.png");
		Image dvd2 = loadImage("images/DVD/DVD2.png");
		Image dvd3 = loadImage("images/DVD/DVD3.png");
		Image dvd4 = loadImage("images/DVD/DVD4.png");
		Image dvd5 = loadImage("images/DVD/DVD5.png");
		Animate dvdAnim = new Animate();

		dvdAnim.addFrame(dvd1, 50);
		dvdAnim.addFrame(dvd2, 50);
		dvdAnim.addFrame(dvd3, 50);
		dvdAnim.addFrame(dvd4, 50);
		dvdAnim.addFrame(dvd5, 50);

		sprite = new Sprite(dvdAnim);
		sprite.setDX((float) 0.2);
		sprite.setDY((float) 0.2);
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

	// Keyboard

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_ESCAPE) {
			stop();
		} else if (keyCode == KeyEvent.VK_BACK_SPACE) {
			if (typed.length() < 1) {
			} else {
				typed = typed.substring(0, typed.length() - 1);
			}
		} else if (keyCode == KeyEvent.VK_SPACE) {
			typed += " ";
		} else {
			typed += KeyEvent.getKeyText(keyCode);
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		// Call a method or change a boolean idk
	}

	/*
	 * The game will crash without this
	 */
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	// Mouse

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseExited(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		if (centering && centerX == e.getX() && centerY == e.getY()) {
			centering = false;
		} else {
			int dx = e.getX() - mouseX;
			int dy = e.getY() - mouseY;
			imageX += dx;
			imageY += dy;
			centerMouse();
		}
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		int multiplier = 5;
		size += e.getWheelRotation() * multiplier;
	}

	public void update(long elapsedTime) {
	}

	public synchronized void centerMouse() {
		Window window = screenManager.getFullScreenWindow();
		if (robot != null && window.isShowing()) {
			centerX = window.getWidth() / 2;
			centerY = window.getHeight() / 2;
			Point centerLocation = new Point();
			centerLocation.x = centerX;
			centerLocation.y = centerY;
			SwingUtilities.convertPointToScreen(centerLocation, window);
			// So mouse move listener doesnt have a stroke
			centering = true;
			robot.mouseMove(centerX, centerY);
		}
	}

	public void draw(Graphics g) {
		Font font = new Font("Comic Sans MS", Font.PLAIN, size);
		g.drawImage(testScreen, imageX, imageY, null);
		g.setFont(font);
		g.drawString(typed, mouseX, mouseY);
	}

}
