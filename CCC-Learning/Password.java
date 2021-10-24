import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Password {
	File file = new File("program.encrypted");
	FileReader in;
	FileWriter out;
	Scanner sc = new Scanner(System.in);
	BufferedReader readFile;
	BufferedWriter writeFile;
	String lineOfText;
	String scoreNameParsed;
	static String top5Names[] = new String[5];
	static int top5Scores[] = new int[5];
	static int lastPosition = -1;

	public void writeScore() {
		if (file.exists()) {
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("IOExeption: " + e.getMessage());
			}
		}
		// Writes
		try {
			out = new FileWriter(file, true);
			writeFile = new BufferedWriter(out);
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

	public void readScore() {
		int j = 0;
		try {
			in = new FileReader(file);
			readFile = new BufferedReader(in);
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOExeption: " + e.getMessage());
		}
	}// Read File

	public static void main(String[] args) {
		Password password = new Password();
		password.writeScore();
	}

}
