
/**
 * Main By: Riley Power
 * IF GRAPHICS FLICKER/SKIP thats because of citrix
 * As far as i know citrix is essentially streaming the game from their server to your computer
 * 
 * -<==< CONTROLS >==>-
 * Left Arrow = Move Left
 * Right Arrow = Move Right
 * Up Arrow = Rotate Piece
 * Down Arrow = Drop Piece 1 Block (Hold for 1 second to make it drop even faster)
 * Shift = Hold Piece (Save a piece for later) You can only hold a piece once per new piece, or else you could cheat.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel implements ActionListener {
	static int type = 0;
	static int rotation = 0;
	static int oldRotation = rotation;
	static long loopTime = 0;
	static boolean calledByShift = false;
	// Used for java.io (Saving High Scores)
	File savedScores = new File("game_scores.txt");
	FileReader in;
	FileWriter out;
	Scanner sc = new Scanner(System.in);
	BufferedReader readFile;
	BufferedWriter writeFile;
	String lineOfText;
	String scoreNameParsed;
	static String top5Names[] = new String[5];
	static int top5Scores[] = new int[5];

	static boolean leftHeld = false;
	static boolean rightHeld = false;
	static boolean upHeld = false;
	static boolean downHeld = false;

	static boolean squareTouchingSomething = false;
	static double squareX = 0;
	static double squareY = 30;
	static double squareXOld = squareX;
	static double squareYOld = squareY;
	static double baseFallSpeed = 0.1;
	static double fallSpeed = 0.1;
	static boolean touching = false;
	static boolean wasTouching = false;
	static int[][] objectCoords = new int[2][3];

	/*
	 * Paint Method Runs when repaint(); is called Paints Where Pieces are, in the
	 * colour they are supposed to be and important information (Score etc.) This
	 * was by far the hardest part, along with making th JFrame in main
	 */
	public void paint(Graphics g) {
		// Main Paint Loop
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// Paints Board
		// Paints holdGraphic
		Color backgroundColor = Color.WHITE;
		g2d.setColor(Color.GREEN);
		g2d.fillRect((int) squareX, (int) squareY - 20, 20, 20);
		for (int i = 1; i >= 0; i--) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(objectCoords[i][1], objectCoords[i][2], 20, 20);
		}
	}// Paint

	/*
	 * Makes a new, random piece pieceType 0 = Normal pieceType 1 = First Of Game
	 * pieceType 2 = Held pieceType 3 = Hold Graphic pieceType 4 = Next PieceGraphic
	 */

	/*
	 * Used For JFrame
	 */
	private static void runGUI() {
		Main game = new Main();
	}// RunGUI

	/*
	 * Appends score, name entered and system time to file
	 */
	public void writeScore() {
		if (savedScores.exists()) {
		} else {
			try {
				savedScores.createNewFile();
			} catch (IOException e) {
				System.err.println("IOExeption: " + e.getMessage());
			}
		}
		// Writes
		try {
			out = new FileWriter(savedScores, true);
			writeFile = new BufferedWriter(out);
			writeFile.write(Integer.toString(1));
			writeFile.newLine();
			writeFile.write(scoreNameParsed);
			writeFile.newLine();
			writeFile.write(Long.toString(System.currentTimeMillis()));
			writeFile.newLine();
			writeFile.close();
			out.close();
		} catch (IOException e) {
			System.err.println("IOExeption: " + e.getMessage());
		}
	}// Write Score

	/*
	 * Reads File, and sorts 5 highest scores into the arrays
	 */
	public void readScore() {
		int j = 0;
		try {
			in = new FileReader(savedScores);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
			}
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOExeption: " + e.getMessage());
		}
	}// Read File

	public void move() {
		int xSpeed = 5;
		if (leftHeld == true) {
			squareX = squareX - xSpeed;
		}
		if (rightHeld == true) {
			squareX = squareX + xSpeed;
		}
	}

	public void gravity() {
		int terminalV = 10;
		if (fallSpeed >= terminalV) {
		} else if (squareTouchingSomething == false) {
			fallSpeed = fallSpeed * 1.1;
		}
		squareY += fallSpeed;
	}

	public void collision() {
		for (int i = 0; i < objectCoords.length; i++) {
			if (squareY >= objectCoords[i][2] && squareY <= objectCoords[i][2] + 20 && squareX >= objectCoords[i][1]
					&& squareX <= objectCoords[i][1] + 20) {
				touching = true;
				fallSpeed = baseFallSpeed;
			}
		}
	}

	public static void main(String[] args) {
		int fps = 60;
		long nextFrame = 0;
		// Constructs JFrame
		JFrame frame = new JFrame("Square Life But In Java And Not Made By A Sixth Grader | By: Riley Power");
		final Main game = new Main();
		frame.add(game);
		frame.setSize(800, 600);

		objectCoords[0][1] = 0;
		objectCoords[0][2] = 400;
		objectCoords[1][1] = 20;
		objectCoords[1][2] = 400;

		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					leftHeld = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					rightHeld = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					upHeld = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					downHeld = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					leftHeld = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					rightHeld = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					upHeld = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					downHeld = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				}
			}
		});

		// Start Game
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Main Game Loop
		while (true) {
			nextFrame = System.currentTimeMillis() + 1000 / fps;
			// Loops until loopTime is over, and forces a drop in piece
			while (System.currentTimeMillis() < nextFrame) {
			}
			game.move();
			touching = false;
			game.collision();
			if(touching == false) {
				game.gravity();
			}
			game.repaint();
		}
	}// Main
}// Main