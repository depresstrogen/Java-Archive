import java.io.*;

public class Slide {
	private char[][] slide;
	private final char COLONY = '*';
	private final char NON_COLONY = '-';

	public Slide(String file) {

		File myFile = new File(file);
		int rows, cols;

		try {
			FileReader fr = new FileReader(myFile);
			BufferedReader inFile = new BufferedReader(fr);

			rows = Integer.parseInt(inFile.readLine());
			cols = Integer.parseInt(inFile.readLine());
			slide = new char[rows][cols];

			for (int row = 0; row < rows; row++) {
				String line = inFile.readLine();
				for (int col = 0; col < cols; col++)
					// read each successive character in the line into an array element

					slide[row][col] = line.charAt(col);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Can't find file");
			System.err.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Can't read from file");
			System.err.println(ioe.getMessage());

		}

	}// constructor

	public void displaySlide() {
		for (int row = 0; row < slide.length; row++) {
			for (int col = 0; col < slide[row].length; col++)
				System.out.print(slide[row][col]);
			System.out.println();
		}

	}// displaySlide

	public void findBacteria() {

		// find the next bacterium by looping through the 2D array
		// when a bacterium is found, the countBacteria method will be called
		for (int row = 0; row < slide.length; row++) {
			for (int col = 0; col < slide[row].length; col++) {
				if (slide[row][col] == COLONY) {
					System.out.print(countBacteria(row, col) + " ");
				}
			}
		}
	}// findBacteria

	public void findBacteriaAndShow() {

		// Same as above except it calls displaySlide after each colony
		for (int row = 0; row < slide.length; row++) {
			for (int col = 0; col < slide[row].length; col++) {
				if (slide[row][col] == COLONY) {
					displaySlide();
					System.out.println(countBacteria(row, col));
				}
			}
		}
		displaySlide();

	}// findBacteriaAndShow

	public int countBacteria(int row, int col) {
		int count = 1;
		slide[row][col] = NON_COLONY;
		// North Check
		if (col - 1 >= 0 && slide[row][col - 1] == COLONY) {
			count += countBacteria(row, col - 1);
		}
		// east
		if (row + 1 < slide.length && slide[row + 1][col] == COLONY) {
			count += countBacteria(row + 1, col);
		}
		// south
		if (col + 1 < slide[row].length && slide[row][col + 1] == COLONY) {
			count += countBacteria(row, col + 1);
		}
		// west
		if (row - 1 >= 0 && slide[row - 1][col] == COLONY) {
			count += countBacteria(row - 1, col);
		}

		// since this a non-void method, there will be a return statement in both base
		// and recursive cases
		// return 0 if the row or col reference is off the slide
		// otherwise return 1 + recursive calls east, south, west and north
		return count;

	}// countBacteria

}// Slide