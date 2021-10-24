import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Generator { 
	static int lengthOfItemText = 50;
	static int numOfBlues = 0;
	static String[] blues = new String[20];
	static int numOfPurples = 0;
	static String[] purples = new String[20];
	static int numOfPinks = 0;
	static String[] pinks = new String[20];
	static int numOfReds = 0;
	static String[] reds = new String[20];
	static int numOfGoldShape = 0;
	static int numOfGoldPaint = 0;
	static String[] goldShape = new String[20];
	static String[] goldPaint = new String[20];
	
	public static String generateRarity(){
		final double blueodds = 79.92327;
		final double purpleodds = blueodds + 15.98465;
		final double pinkodds = purpleodds + 3.19693;
		final double redodds = pinkodds + 0.63939;
		final double goldodds = redodds + 0.25565; 
		double rarity = 0;
		String itemRarity;
		rarity = (Math.random()) * 100;
		
		if (rarity <= blueodds) {
			itemRarity = "blue";
		} else if (rarity <= purpleodds) {
			itemRarity = "purple";
		} else if (rarity <= pinkodds) {
			itemRarity = "pink";
		} else if (rarity <= redodds) {
			itemRarity = "red";
		} else if (rarity <= goldodds) {
			itemRarity = "gold";
		} else {
			itemRarity = "ass";
		}
		return itemRarity;
	}
	
	public static String generateItem(String rarity) {
		int itemNum = 0;
		String item = "";
		
		if (rarity.equals("blue")) {
			itemNum = (int)((Math.random()) * numOfBlues);
			item = blues[itemNum];
		} else if (rarity.equals("purple")) {
			itemNum = (int)((Math.random()) * numOfPurples);
			item = purples[itemNum];
		} else if (rarity.equals("pink")) {
			itemNum = (int)((Math.random()) * numOfPinks);
			item = pinks[itemNum];
		} else if (rarity.equals("red")) {
			itemNum = (int)((Math.random()) * numOfReds);
			item = reds[itemNum];
		} else if (rarity.equals("gold")) {
			itemNum = (int)((Math.random()) * numOfGoldShape);
			item = goldShape[itemNum];
			itemNum = (int)((Math.random()) * numOfGoldPaint);
			item = item + " | " + goldPaint[itemNum];
		} else {
			item = "heck";
		}
		
		
		double floatValue = Math.random();
		String condition = "";
		if (floatValue < 0.07) {
			condition = "Factory New";
		} else if (floatValue < 0.15) {
			condition = "Minimal Wear";
		} else if (floatValue < 0.38) {
			condition = "Field Tested";
		} else if (floatValue < 0.45) {
			condition = "Well Worn";
		} else if (floatValue < 1) {
			condition = "Battle Scarred";
		} else {
			condition = "shit";
		}
		
		int stat = (int) (Math.random() * 10);
		String stattrak = "";
		if (stat == 9) {
			stattrak = "StatTrak ";
		}

		String blankSpace = "";
		for (int i = item.length() + stattrak.length(); i <= lengthOfItemText; i++) {
			blankSpace = blankSpace + " ";
		}
		
		item = stattrak + item + blankSpace + condition; 
		
		return item;
	}
	
	public static String textColour(String rarity) {
		String textMod = "";
		String blueText = "\033[38;5;12m"; 
		String purpleText = "\033[38;5;13m"; 
		String pinkText = "\033[38;5;219m"; 
		String redText = "\033[38;5;196m"; 
		String goldText = "\033[38;5;226m";
		
		if (rarity.equals("blue")) {
			textMod = blueText;
		} else if (rarity.equals("purple")) {
			textMod = purpleText;
		} else if (rarity.equals("pink")) {
			textMod = pinkText;
		} else if (rarity.equals("red")) {
			textMod = redText;
		} else if (rarity.equals("gold")) {
			textMod = goldText;
		} else {
			textMod = "heck";
		}
		return textMod;
	}
	
	public static void setKnives(String caseName) {
		String knifePaintType = "";
		String knifeShapeType = "";
		switch (caseName) {
			case "[Bravo]":
				knifePaintType = "[Arms Deal]";
				knifeShapeType = "[Arms Deal]";
				break;
			case "[Spectrum]":
			case "[Spectrum 2]":
				knifePaintType = "[Chroma]";
				knifeShapeType = "[Spectrum]";
				break;
			case "[Danger Zone]":
				knifePaintType = "[Arms Deal]";
				knifeShapeType = "[Horizon]";
				break;
			case "[Prisma]":
			case "[Prisma 2]":
				knifePaintType = "[Chroma]";
				knifeShapeType = "[Horizon]";
				break;
		}
		FileReader in;
		FileWriter out;
		BufferedReader readFile;
		BufferedWriter writeFile;
		String lineOfText = "";
		String whereInCase = "";
		String currentItem = "";
		boolean inCase = false;
		boolean inBracket = false;
		boolean inPaint = false;
		boolean inKnife = false;
		File paintIndex = new File("finishes.txt");
		File knifeIndex = new File("knives.txt");
		int n = 0;
		try {
				in = new FileReader(paintIndex);
				readFile = new BufferedReader(in);
				while ((lineOfText = readFile.readLine()) != null) {
					if (inBracket == true) {
						inBracket = false;
					}
					if (lineOfText.equals(knifePaintType)) {
						inPaint = true;
						inBracket = true;
					} else if (lineOfText.charAt(0) == '[' && inPaint == true) {
						inPaint = false;
					}
					else if (inPaint == true && inBracket == false) {
						currentItem = lineOfText.substring(2);
						goldPaint[n] = currentItem;
						n++;
					}
				}
				numOfGoldPaint = n;
				readFile.close();
				in.close();
			} catch (IOException e) {
				System.out.println("Problem reading file");
				System.err.println("IOExeption: " + e.getMessage());
			}
		n = 0;
		try {
			in = new FileReader(knifeIndex);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
				if (inBracket == true) {
					inBracket = false;
				}
				if (lineOfText.equals(knifeShapeType)) {
					inKnife = true;
					inBracket = true;
				} else if (lineOfText.charAt(0) == '[' && inKnife == true) {
					inKnife = false;
				}
				else if (inKnife == true && inBracket == false) {
					currentItem = lineOfText.substring(2);
					goldShape[n] = currentItem;
					n++;
				}
			}
			numOfGoldShape = n;
			readFile.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Problem reading file");
			System.err.println("IOExeption: " + e.getMessage());
		}

	}

	public static void setGuns(String caseName) {
		FileReader in;
		FileWriter out;
		BufferedReader readFile;
		BufferedWriter writeFile;
		String lineOfText = "";
		String whereInCase = "";
		String currentItem = "";
		boolean inCase = false;
		boolean inBracket = false;
		File gunIndex = new File("guns.txt");
		 int n = 0;
		 try {
				in = new FileReader(gunIndex);
				readFile = new BufferedReader(in);
				while ((lineOfText = readFile.readLine()) != null) {
					if (inBracket == true) {
						inBracket = false;
					}
					if (lineOfText.equals(caseName)) {
						inCase = true;
					} else if (lineOfText.charAt(0) == '[' && inCase == true) {
						inCase = false;
						numOfReds = n;
						n = 0;
					}
					if (inCase == true && lineOfText.equals("(Blues)")) {
						whereInCase = "blue";
						inBracket = true;
						n = 0;
					} else if (inCase == true && lineOfText.equals("(Purples)")) {
						whereInCase = "purple";
						inBracket = true;
						numOfBlues = n;
						n = 0;
					} else if (inCase == true && lineOfText.equals("(Pinks)")) {
						whereInCase = "pink";
						inBracket = true;
						numOfPurples = n;
						n = 0;
					} else if (inCase == true && lineOfText.equals("(Reds)")) {
						whereInCase = "red";
						inBracket = true;
						numOfPinks = n;
						n = 0;
					}
					if (inCase == true && inBracket == false && whereInCase.equals("blue")) {
						currentItem = lineOfText.substring(2);
						blues[n] = currentItem;
						n ++;
					} else if (inCase == true && inBracket == false && whereInCase.equals("purple")) {
						currentItem = lineOfText.substring(2);
						purples[n] = currentItem;
						n ++;
					} else if (inCase == true && inBracket == false && whereInCase.equals("pink")) {
						currentItem = lineOfText.substring(2);
						pinks[n] = currentItem;
						n ++;
					} else if (inCase == true && inBracket == false && whereInCase.equals("red")) {
						currentItem = lineOfText.substring(2);
						reds[n] = currentItem;
						n ++;
					}
				}
				readFile.close();
				in.close();
			} catch (IOException e) {
				System.out.println("Problem reading file");
				System.err.println("IOExeption: " + e.getMessage());
			}
	}
	
	public static void main(String[] args) {
		boolean exit = false;
		boolean delay = false;
		int delayNumber = 100;
		Scanner sc = new Scanner(System.in);
		System.out.println("Case Opening Simulator \"Copyright\" 2020 By Riley");
		System.out.println("Choose A Case To Open");
		System.out.println("(1) Bravo Case");
		System.out.println("(2) Spectrum 2 Case");
		System.out.println("(3) Danger Zone Case");
		System.out.println("(4) Prisma 2 Case");
		String caseToOpen = "";
		int choice = sc.nextInt();
		if (choice == 1) {
			caseToOpen = "[Bravo]";
		} else if (choice == 2) {
			caseToOpen = "[Spectrum 2]";
		} else if (choice == 3) {
			caseToOpen = "[Danger Zone]";
		} else if (choice == 4) {
			caseToOpen = "[Prisma 2]";
		} else {
			System.out.println("Fuck");
			try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            System.err.println("MFW the error gets an error /('O')\\");
	        }
		}
		choice = 0;
		int numberOpened = 0;
		String rarity = "";
		String item = "";
		String textMod = "";
		setKnives(caseToOpen);
		setGuns(caseToOpen);
		while (exit != true) {
			while(rarity.equals("gold") != true) {
				numberOpened ++;
				rarity = generateRarity();
				item = generateItem(rarity);
				textMod = textColour(rarity);
				System.out.print(textMod);
				System.out.println(item + "    " + numberOpened);
				if (delay == true) {
					try {
			            Thread.sleep(delayNumber);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
				}
			}
			if (choice != 3) {
				System.out.println("Press 1 To Open More");
				System.out.println("Press 2 To Exit");
				System.out.println("Press 3 To Loop Until Error");
				System.out.println("Press 4 To Toggle Delay");
				System.out.println("Press 5 To Change Delay");
				choice = 0;
				choice = sc.nextInt();
			}
			if (choice == 2) {
				exit = true;
			}
			if (choice == 4) {
				delay = !delay;
			}
			if (choice == 5) {
				System.out.println("Type Desired Delay (ms)");
				delayNumber = sc.nextInt();
				System.out.println("Delay set to " + delayNumber + " ms");

			}
			rarity = "";
		}
	}
}
