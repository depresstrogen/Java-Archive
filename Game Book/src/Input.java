import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Input extends JFrame implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	int mouseX = 0;
	int mouseY = 0;
	Robot robot;
	int centerX;
	int centerY;
	Component comp;
	boolean centering;
	// Trick i 100% didnt have to google to get a blank cursor
	Cursor antiCursor = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(""),
			new Point(0, 0), "invisible");

	// Keylistener > Mouselistener
	public static final int MOUSE_MOVE_LEFT = 0;
	public static final int MOUSE_MOVE_RIGHT = 1;
	public static final int MOUSE_MOVE_UP = 2;
	public static final int MOUSE_MOVE_DOWN = 3;
	public static final int MOUSE_WHEEL_UP = 4;
	public static final int MOUSE_WHEEL_DOWN = 5;
	public static final int MOUSE_BUTTON_1 = 6;
	public static final int MOUSE_BUTTON_2 = 7;
	public static final int MOUSE_BUTTON_3 = 8;
	public static final int TOTAL_MOUSE_CODES = 9;

	public static final int TOTAL_KEY_CODES = 600;

	private Actions[] keyActions = new Actions[TOTAL_KEY_CODES];
	private Actions[] mouseActions = new Actions[TOTAL_MOUSE_CODES];

	// Keyboard

	public Input(Component comp) {
		this.comp = comp;
		comp.addKeyListener(this);
		comp.addMouseListener(this);
		comp.addMouseMotionListener(this);
		comp.addMouseWheelListener(this);
		comp.setFocusTraversalKeysEnabled(false);
	}

	public void lockMouse(boolean mode) {
		if (mode == isMouseLocked()) {
			return;
		}
		if (mode) {
			try {
				robot = new Robot();
				centerMouse();
			} catch (AWTException ex) {
				robot = null;
			}
		} else {
			robot = null;
		}
	}

	public boolean isMouseLocked() {
		return (robot != null);
	}

	public void mapToKey(Actions action, int key) {
		keyActions[key] = action;
	}

	public void mapToMouse(Actions action, int mouse) {
		mouseActions[mouse] = action;
	}

	public void clearBinds(Actions action) {
		for (int i = 0; i < keyActions.length; i++) {
			if (keyActions[i] == action) {
				keyActions[i] = null;
			}
		}

		for (int i = 0; i < mouseActions.length; i++) {
			if (mouseActions[i] == action) {
				mouseActions[i] = null;
			}
		}
	}

	public void getBinds(Actions action) {
		ArrayList binds = new ArrayList();
		for (int i = 0; i < keyActions.length; i++) {
			if (keyActions[i] == action) {
				binds.add(getKeyName(i));
			}
		}

		for (int i = 0; i < mouseActions.length; i++) {
			if (mouseActions[i] == action) {
				binds.add(getMouseName(i));
			}
		}
	}

	public void resetAllActions() {
		for (int i = 0; i < keyActions.length; i++) {
			if (keyActions[i] != null) {
				keyActions[i].reset();
			}
		}
		for (int i = 0; i < mouseActions.length; i++) {
			if (mouseActions[i] != null) {
				mouseActions[i].reset();
			}
		}
	}

	public static String getKeyName(int key) {
		return KeyEvent.getKeyText(key);
	}

	public static String getMouseName(int mouse) {
		switch (mouse) {
		case MOUSE_MOVE_LEFT:
			return "Mouse Left";
		case MOUSE_MOVE_RIGHT:
			return "Mouse Right";
		case MOUSE_MOVE_UP:
			return "Mouse Up";
		case MOUSE_MOVE_DOWN:
			return "Mouse Down";
		case MOUSE_WHEEL_UP:
			return "Mouse Wheel Up";
		case MOUSE_WHEEL_DOWN:
			return "Mouse Wheel Down";
		case MOUSE_BUTTON_1:
			return "Mouse Button 1";
		case MOUSE_BUTTON_2:
			return "Mouse Button 2";
		case MOUSE_BUTTON_3:
			return "Mouse Button 3";
		default:
			return "Mouse " + mouse;
		}
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	private Actions getKeyAction(KeyEvent e) {
		int key = e.getKeyCode();
		if (key < keyActions.length) {
			return keyActions[key];
		} else {
			return null;
		}
	}

	private Actions getMouseButtonAction(MouseEvent e) {
		int mouseCode = getMouseButtonCode(e);
		if (mouseCode != -1) {
			return mouseActions[mouseCode];
		} else {
			return null;
		}
	}

	public static int getMouseButtonCode(MouseEvent e) {
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			return MOUSE_BUTTON_1;
		case MouseEvent.BUTTON2:
			return MOUSE_BUTTON_2;
		case MouseEvent.BUTTON3:
			return MOUSE_BUTTON_3;
		default:
			return -1;
		}
	}

	public void setCursor(Cursor cursor) {
		comp.setCursor(cursor);
	}

	public void keyPressed(KeyEvent e) {
		Actions action = getKeyAction(e);
		if (action != null) {
			action.press();
		}
		e.consume();
	}

	public void keyReleased(KeyEvent e) {
		Actions action = getKeyAction(e);
		if (action != null) {
			action.release();
		}
		e.consume();
	}

	/*
	 * The game will crash without this
	 */
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	// Mouse

	public void mousePressed(MouseEvent e) {
		Actions action = getMouseButtonAction(e);
		if (action != null) {
			action.press();
		}
		e.consume();
	}

	public void mouseReleased(MouseEvent e) {
		Actions action = getMouseButtonAction(e);
		if (action != null) {
			action.release();
		}
		e.consume();
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

			mouseHelper(MOUSE_MOVE_LEFT, MOUSE_MOVE_RIGHT, dx);
			mouseHelper(MOUSE_MOVE_UP, MOUSE_MOVE_DOWN, dy);
			if (isMouseLocked()) {
				centerMouse();
			}
		}
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseHelper(MOUSE_WHEEL_UP, MOUSE_WHEEL_DOWN, e.getWheelRotation());
	}

	public void update(long elapsedTime) {
	}

	public synchronized void centerMouse() {
		if (robot != null && comp.isShowing()) {
			centerX = comp.getWidth() / 2;
			centerY = comp.getHeight() / 2;
			Point centerLocation = new Point();
			centerLocation.x = centerX;
			centerLocation.y = centerY;
			SwingUtilities.convertPointToScreen(centerLocation, comp);
			// So mouse move listener doesnt have a stroke
			centering = true;
			robot.mouseMove(centerX, centerY);
		}
	}

	private void mouseHelper(int codeNeg, int codePos, int amount) {
		Actions action;
		if (amount < 0) {
			action = mouseActions[codeNeg];
		} else {
			action = mouseActions[codePos];
		}
		if (action != null) {
			action.press(Math.abs(amount));
			action.release();
		}
	}
}
