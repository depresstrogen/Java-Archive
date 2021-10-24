import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel implements ActionListener {
	static String difficulty = "expert";
	// Stores the piece positions 1 is placed piece 2 is active piece
	static int[][] chart = new int[Chart.chartLength(difficulty)][10];
	static int beat = 0;
	static int pieceSize = 30;
	static int lastGoodBeat = 0;
	// Outside of method as they are used for JFrame too
	static int boardX = 200;
	static int boardY = 0;
	static int boardBottom = 1000;
	public void paint(Graphics g) {
		// Main Paint Loop
		boolean sameLine = true;
		int line = 0;
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		int length = Chart.chartLength(difficulty);
		// Paints Board
		for (int i = 0; i < length; i++) {
			while (sameLine == true) {
				if (chart[i][4] != -1) {
					switch (chart[i][4]){
					case 0:
						g2d.setColor(Color.GREEN);
						break;
					case 1:
						g2d.setColor(Color.RED);
						break;
					case 2:
						g2d.setColor(Color.YELLOW);
						break;
					case 3:
						g2d.setColor(Color.BLUE);
						break;
					case 4:
						g2d.setColor(Color.ORANGE);
						break;
					}
					if (chart[i][2] == beat) {
						lastGoodBeat = beat;
					}
					if (chart[i][3] == 2) {
					}
					else if (chart[i][2] == lastGoodBeat) {
						g2d.fillRect(chart[i][4] * pieceSize + boardX, pieceSize + boardY, pieceSize, pieceSize);
						g2d.setColor(Color.BLACK);
						g2d.drawRect(chart[i][4] * pieceSize + boardX, pieceSize + boardY, pieceSize, pieceSize);
					}
				} else {
				}
				if (chart[i][2] == chart[i + 1][2]) {
					sameLine = true;
					i++;
				} else {
					sameLine = false;
					line ++;
				}
			}
			sameLine = true;
		}
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0 * pieceSize + boardX, boardBottom - 100 + boardY, pieceSize, pieceSize);
		g2d.setColor(Color.RED);
		g2d.fillRect(1 * pieceSize + boardX, boardBottom - 100 + boardY, pieceSize, pieceSize);
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(2 * pieceSize + boardX, boardBottom - 100 + boardY, pieceSize, pieceSize);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(3 * pieceSize + boardX, boardBottom - 100 + boardY, pieceSize, pieceSize);
		g2d.setColor(Color.ORANGE);
		g2d.fillRect(4 * pieceSize + boardX, boardBottom - 100 , pieceSize, pieceSize);
	}// Paint

	/*
	 * Reads File, and sorts 5 highest scores into the arrays
	 */

	public static void main(String[] args) {
		// Variables
		double loopTime = System.currentTimeMillis() + 300;
		chart = Chart.makeChart(difficulty);
		int[][] tenNextLines = new int[10][7];
		double loopAdder = 1000 / 1000;
		// Constructs JFrame
		JFrame frame = new JFrame("\"Guitar Hero\" | By: Riley Power");
		final Main guitar = new Main();
		frame.add(guitar);
		frame.setSize(boardX + 317 + boardX, 1000);

		// Key Listener Activates Shift/Rotate/Drop Methods on key press
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Chart.chartLength(difficulty);
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
		for(int i = 0; i < 821; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print("." + chart[i][j] + ".");
			}
			System.out.println();
		}
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Main Game Loop
		while (true) {
			loopTime = System.currentTimeMillis() + loopAdder;
			guitar.repaint();
			// Loops until loopTime is over, and forces a drop in piece
			while (System.currentTimeMillis() < loopTime) {
				guitar.repaint();
			}
			beat ++;
		}
	}// Main Method
}// Main Class