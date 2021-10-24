import java.io.*;
import java.util.Scanner;

public class MyFile {
	public static void main(String[] args) {
		File savedScores = new File("tetris_scores.txt");
		FileReader in;
		FileWriter out;
		Scanner sc = new Scanner(System.in);
		BufferedReader readFile;
		BufferedWriter writeFile;
		String lineOfText;
		int fileLength = 0;
		int score = (int) (Math.random() * 100);
		// Creates
		if (savedScores.exists()) {
		} else {
			try {
				savedScores.createNewFile();
				System.out.println("File created");
			} catch (IOException e) {
				System.out.println("File can't be created");
				System.err.println("IOExeption: " + e.getMessage());
			}
		}
//		//Writes
//		try {
//			out = new FileWriter(savedScores,true);
//			writeFile = new BufferedWriter(out);
//			String write = sc.nextLine();
//			writeFile.write(Integer.toString(score));
//			writeFile.newLine();
//			writeFile.write(write);
//			writeFile.newLine();
//			writeFile.write(Long.toString(System.currentTimeMillis()));
//			writeFile.newLine();
//			writeFile.close();
//			out.close();
//		} catch (IOException e) {
//			System.out.println("Problem writing to file");
//			System.err.println("IOExeption: " + e.getMessage());
//		}
//		//Reads
//		try {
//			in = new FileReader(savedScores);
//			readFile = new BufferedReader(in);
//			while ((lineOfText = readFile.readLine()) != null) {
//				System.out.println(lineOfText);
//			}
//			readFile.close();
//			in.close();
//		} catch (IOException e) {
//			System.out.println("Problem reading file");
//			System.err.println("IOExeption: " + e.getMessage());
//		}
//		
//		try {
//		BufferedReader reader = new BufferedReader(new FileReader(savedScores));
//		while (reader.readLine() != null) {
//			fileLength++;
//		}
//		reader.close();
//		} catch (IOException e) {
//			System.out.println("Problem reading file");
//			System.err.println("IOExeption: " + e.getMessage());
//		}
		// Sorts Top 5
		String top5Names[] = new String[5];
		int top5Scores[] = new int[5];
		int lastPosition = -1;
		top5Scores[0] = -1;
		int j = 0;
		try {
			in = new FileReader(savedScores);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
				if (j % 3 == 0) {
					if ((top5Scores[0]) < Integer.parseInt(lineOfText)) {
						top5Scores[4] = top5Scores[3];
						top5Scores[3] = top5Scores[2];
						top5Scores[2] = top5Scores[1];
						top5Scores[1] = top5Scores[0];
						top5Scores[0] = Integer.parseInt(lineOfText);
						lastPosition = 0;
					} else if ((top5Scores[1]) < Integer.parseInt(lineOfText)) {
						top5Scores[4] = top5Scores[3];
						top5Scores[3] = top5Scores[2];
						top5Scores[2] = top5Scores[1];
						top5Scores[1] = Integer.parseInt(lineOfText);
						lastPosition = 1;
					} else if ((top5Scores[2]) < Integer.parseInt(lineOfText)) {
						top5Scores[4] = top5Scores[3];
						top5Scores[3] = top5Scores[2];
						top5Scores[2] = Integer.parseInt(lineOfText);
						lastPosition = 2;
					} else if ((top5Scores[3]) < Integer.parseInt(lineOfText)) {
						top5Scores[4] = top5Scores[3];
						top5Scores[3] = Integer.parseInt(lineOfText);
						lastPosition = 3;
					} else if ((top5Scores[4]) < Integer.parseInt(lineOfText)) {
						top5Scores[4] = Integer.parseInt(lineOfText);
						lastPosition = 4;
					} else {
						lastPosition = -1;
					}
				}
				if (j % 3 == 1) {
					if (lastPosition == 0) {
						top5Names[4] = top5Names[3];
						top5Names[3] = top5Names[2];
						top5Names[2] = top5Names[1];
						top5Names[1] = top5Names[0];
						top5Names[0] = lineOfText;
					} else if (lastPosition == 1) {
						top5Names[4] = top5Names[3];
						top5Names[3] = top5Names[2];
						top5Names[2] = top5Names[1];
						top5Names[1] = lineOfText;
					} else if (lastPosition == 2) {
						top5Names[4] = top5Names[3];
						top5Names[3] = top5Names[2];
						top5Names[2] = lineOfText;
					} else if (lastPosition == 3) {
						top5Names[4] = top5Names[3];
						top5Names[3] = lineOfText;
					} else if (lastPosition == 4) {
						top5Names[4] = lineOfText;
					}
				}
				j++;
			}
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOExeption: " + e.getMessage());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(top5Scores[i]);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(top5Names[i]);
		}
	}
}
