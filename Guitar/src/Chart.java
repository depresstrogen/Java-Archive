import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chart {
	static String lineOfText = "";
	static int j = 0;
	static String partOfChart = "";
	static String currentDifficulty = "";
	static int lengthOfChart = 0;
	static int[][] chart;
	static File chartFile = new File("notes.chart");
	static String hardness = "expert";
	
	public Chart() {
		makeChart(hardness);
	}
	public Chart(int[][] chart) {
		
	}
	public static int[] parseChartLine() {
		String temp = " ";
		int tempNum = 0;
		char tempChar = ' ';
		int partOfLine = 0;
		boolean isTempNum = true;
		int[] parsedLine = new int[7];
		int withSkipped = 0;

		for (int i = 0; i < lineOfText.length(); i++) {
			isTempNum = true;
			if (lineOfText.charAt(i) == ' ' || i + 1 == lineOfText.length() - 1) {
				for (int j = 0; j < temp.length(); j++) {
					tempChar = temp.charAt(j);
					if (temp.equals("")) {
						isTempNum = false;
					} else if (tempChar == '0' || tempChar == '1' || tempChar == '2' || tempChar == '3'
							|| tempChar == '4' || tempChar == '5' || tempChar == '6' || tempChar == '7'
							|| tempChar == '8' || tempChar == '9' || tempChar == ' ') {
					} else {
						isTempNum = false;
					}
					// System.out.println(temp);
				}
				if (temp.trim().equals("")) {

				} else if (isTempNum && partOfLine == 5) {
					tempNum = Integer.parseInt(temp.trim()) * 100;
				} else if (isTempNum) {
					tempNum = Integer.parseInt(temp.trim());
				} else if (temp.trim().charAt(0) == 'N') {
					tempNum = 1;
				} else if (temp.trim().charAt(0) == 'S') {
					tempNum = 2;
				}else if (partOfLine == 0 || partOfLine == 2 || partOfLine == 6) {
					withSkipped --;
				} else {
					tempNum = -1;
				}
				if (temp.equals(" ")) {

				} else {
					withSkipped++;
					parsedLine[withSkipped] = tempNum;
					partOfLine++;
				}
				temp = "";
			} else {
				temp = temp + lineOfText.charAt(i);
			}
		}
		return parsedLine;
	}

	public static int chartLength(String difficulty) {
		FileReader in;
		FileWriter out;
		Scanner sc = new Scanner(System.in);
		BufferedReader readFile;
		BufferedWriter writeFile;
		int chartLength = 0;
		try {
			in = new FileReader(chartFile);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
				if (lineOfText.charAt(0) == '[') {
					partOfChart = "";
				}
				if (lineOfText.equals("[ExpertSingle]")) {
					partOfChart = "expert";
				}
				if (lineOfText.equals("[HardSingle]")) {
					partOfChart = "hard";
				}
				if (lineOfText.equals("[MediumSingle]")) {
					partOfChart = "medium";
				}
				if (lineOfText.equals("[EasySingle]")) {
					partOfChart = "easy";
				}
				if (partOfChart.equals(currentDifficulty)) {
					if (lineOfText.charAt(0) == '[' || lineOfText.charAt(0) == '{' || lineOfText.charAt(0) == '}') {
					} else {
						chartLength++;
					}
				}
			}
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOException: " + e.getMessage());
		}
		return chartLength;
	}

	public static int[][] makeChart(String difficulty) {
		FileReader in;
		BufferedReader readFile;
		int lineInChart = 0;
		int[] parsedLine = new int[7];
		chart = new int[160000][7];
		currentDifficulty = difficulty;
		try {
			in = new FileReader(chartFile);
			readFile = new BufferedReader(in);
			
			while ((lineOfText = readFile.readLine()) != null) {
				if (lineOfText.charAt(0) == '[') {
					partOfChart = "";
				}
				if (lineOfText.equals("[ExpertSingle]")) {
					partOfChart = "expert";
				}
				if (lineOfText.equals("[HardSingle]")) {
					partOfChart = "hard";
				}
				if (lineOfText.equals("[MediumSingle]")) {
					partOfChart = "medium";
				}
				if (lineOfText.equals("[EasySingle]")) {
					partOfChart = "easy";
				}
				if (partOfChart.equals(difficulty)) {
					if (lineOfText.charAt(0) == '[' || lineOfText.charAt(0) == '{' || lineOfText.charAt(0) == '}') {
					} else {
						parsedLine = parseChartLine();
						for (int i = 0; i < 7; i++) {
							chart[lineInChart][i] = parsedLine[i];
						}
						System.out.println();
						lineInChart++;
					}
				}
			}
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOException: " + e.getMessage());
		}
		System.out.println(chartLength(difficulty));
		return chart;
	}// Main
}// Class
