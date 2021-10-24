import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

// Can i speak to your
public class ScreenManager {

	private GraphicsDevice device;

	// New Screen Manager Object
	public ScreenManager() {
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = environment.getDefaultScreenDevice();
	}// ScreenManager

	public DisplayMode[] getCompatibleDisplayModes() {
		return device.getDisplayModes();
	}

	public DisplayMode findFirstCompatibleMode(DisplayMode[] possibleModes) {
		DisplayMode screenModes[] = device.getDisplayModes();
		for (int i = 0; i < possibleModes.length; i++) {
			for (int j = 0; j < screenModes.length; j++) {
				if (displayModesMatch(possibleModes[i], screenModes[j])) {

				}
			}
		}
		return null;
	}

	public DisplayMode getCurrentDisplayMode() {
		return device.getDisplayMode();
	}

	public boolean displayModesMatch(DisplayMode modeA, DisplayMode modeB) {

		if (modeA.getWidth() != modeB.getWidth() || modeA.getHeight() != modeB.getHeight()) {
			return false;
		}
		if (modeA.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && modeB.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
				&& modeA.getBitDepth() != modeB.getBitDepth()) {
			return false;
		}
		if (modeA.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
				&& modeB.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
				&& modeA.getRefreshRate() != modeB.getRefreshRate()) {
			return false;
		}

		return true;
	}

	// Enters Fullscreen and intitialises JFrame
	public void setFullScreen(DisplayMode displayMode) {
		// Removes Useless things
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getIgnoreRepaint();
		// Fullscreen
		device.setFullScreenWindow(frame);

		// Changes display mode to best settings
		if (displayMode != null && device.isDisplayChangeSupported()) {
			try {
				device.setDisplayMode(displayMode);
			} catch (IllegalArgumentException ex) {
				// Idk its not like i can do anything useful here
			}
		}
		frame.createBufferStrategy(2);
	}// setFullScreen

	public Graphics2D getGraphics() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			BufferStrategy strategy = window.getBufferStrategy();
			return (Graphics2D) strategy.getDrawGraphics();
		} else {
			return null;
		}
	}

	public void update() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			BufferStrategy strategy = window.getBufferStrategy();
			if (!strategy.contentsLost()) {
				strategy.show();
			}
			Toolkit.getDefaultToolkit().sync();
		}
	}

	// Returns Current Window
	public Window getFullScreenWindow() {
		return device.getFullScreenWindow();
	} // getFullScreenWindow

	public int getWidth() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			return window.getWidth();
		} else {
			return 0;
		}
	}

	public int getHeight() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			return window.getHeight();
		} else {
			return 0;
		}
	}

	// Kill window
	public void restoreScreen() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			window.dispose();
		}
		device.setFullScreenWindow(null);
	}

	public Image compatibleImage(int w, int h, int transparency) {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			GraphicsConfiguration gc = window.getGraphicsConfiguration();
			return gc.createCompatibleImage(w, h, transparency);
		}
		return null;
	}
}
