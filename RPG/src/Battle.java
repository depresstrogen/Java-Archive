import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Battle extends JPanel {
	// Stores the piece positions 1 is placed piece 2 is active piece
	static int beat = 0;
	static int pieceSize = 30;
	static int lastGoodBeat = 0;
	// Outside of method as they are used for JFrame too
	static int windowX = 1000;
	static int windowY = 600;
	static int boardBottom = 1000;
	public void paint(Graphics g) {
		// Battle Paint Loop
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// Paints Board
		
		g2d.fillRect(0, windowY / 2, windowX, windowY / 2);
		GradientRect(0,0,256,256,g2d);
	}// Paint

	/*
	 * Reads File, and sorts 5 highest scores into the arrays
	 */

	public void GradientRect(int x, int y, int sizeX, int sizeY, Graphics2D g2d) {
		double xTo255 = x / 255;
		int cornerA[] = new int[3];
		cornerA[0] = 255;
		cornerA[1] = 0;
		cornerA[2] = 0;
		int cornerB[] = new int[3];
		cornerB[0] = 0;
		cornerB[1] = 0;
		cornerB[2] = 255;	
		double cornerAOffset[] = new double[3];
		double cornerBOffset[] = new double[3];
		for (int i = 0; i < sizeX; i ++) {
			for (int j = 0; j < sizeY; j ++) {
				
				cornerAOffset[0] = cornerA[0]  ();
				Color current = new Color(cornerA[0] + cornerB[0],cornerA[1] + cornerB[1] ,cornerA[2] + cornerB[2]);
				g2d.setColor(current);
				g2d.fillRect(1, 1, i + x, j + y);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// Variables
		double loopTime = System.currentTimeMillis() + 300;
		double loopAdder = 1000 / 60;
		// Constructs JFrame
		JFrame frame = new JFrame("RPG Menu| By: Riley Power");
		final Battle rpg = new Battle();
		frame.add(rpg);
		frame.setSize(windowX, windowY);

		// Key Listener Activates Shift/Rotate/Drop Methods on key press
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				}
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		// Start Game
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Battle Game Loop
		while (true) {
			loopTime = System.currentTimeMillis() + loopAdder;
			windowX = frame.getWidth();
			windowY = frame.getHeight();
			// Loops until loopTime is over, and forces a drop in piece
			while (System.currentTimeMillis() < loopTime) {
				rpg.repaint();
			}
		}
	}// Battle Method
}// Battle Class
