import java.util.Scanner;

public class APlusBHard {
	static final int ASCII_0 = 48;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String loopNotInt = sc.nextLine();
		int numLoops = Integer.parseInt(loopNotInt);
		String input;
		String a, b, finalNumber;
		for (int i = 0; i < numLoops; i++) {

			input = sc.nextLine();

			a = input.substring(0, input.indexOf(' '));
			b = input.substring(input.indexOf(' ') + 1);

			finalNumber = "";
			boolean aIsPositive = true;
			boolean bIsPositive = true;

			if (a.charAt(0) == '-') {
				aIsPositive = false;
				a = a.substring(1);
			}

			if (b.charAt(0) == '-') {
				bIsPositive = false;
				b = b.substring(1);
			}
			
			// Make equal Length
			if (b.length() > a.length()) {
				a = addZeroes(a, b.length() - a.length());
			}

			if (a.length() > b.length()) {
				b = addZeroes(b, a.length() - b.length());
			}
			
			
			if (aIsPositive && bIsPositive) {
				finalNumber = removeStartingZeroes(addNumsReal(a, b));
			}

			if (aIsPositive && !bIsPositive) {
				boolean biggerNumber = biggerNumber(a, b);
				// if a
				if (biggerNumber) {
					finalNumber = removeStartingZeroes(subNums(b, a));
				} else {
					finalNumber = "-" + removeStartingZeroes(subNums(a, b));
				}
			}

			if (!aIsPositive && bIsPositive) {
				boolean biggerNumber = biggerNumber(a, b);
				// if a
				if (biggerNumber) {
					finalNumber = "-" + removeStartingZeroes(subNums(b, a));
				} else {
					finalNumber = removeStartingZeroes(subNums(a, b));
				}
			}
			
			if (!aIsPositive && !bIsPositive) {
				finalNumber = "-" + removeStartingZeroes(addNumsReal(a, b));
			}
			
			finalNumber = removeStartingZeroes(finalNumber);
			

			
			System.out.println(finalNumber);

		}
	}// main

	
	public static String addNumsReal(String a, String b) {
		// a - b
		
		
		StringBuilder stillFast = new StringBuilder(b.length() + a.length());
		
		// a - b
		int currentA, currentB;
		int basicAdd = 0;
		int carry = 0;
		String answer = "";
		for (int i = b.length() - 1; i >= 0; i--) {

			currentA = a.charAt(i) - ASCII_0;
			currentB = b.charAt(i) - ASCII_0;

			basicAdd = currentA + currentB + carry;

			carry = basicAdd / 10;

			basicAdd = basicAdd % 10;

			stillFast.append(basicAdd);
			
		}
		
		stillFast.append(carry);
		stillFast.reverse();
		answer = stillFast.toString();
		return answer;
	}
	//This one doesnt add the carry at the end to save cpu time
	public static String addNums(String a, String b) {
		int len = (b.length() >= a.length())? b.length(): a.length();
		StringBuilder stillFast = new StringBuilder(len + 1);

		// a - b
		int currentA, currentB;
		int basicAdd = 0;
		int carry = 0;
		String answer = "";
		
		for (int i = b.length() - 1; i >= 0; i--) {

			currentA = a.charAt(i) - ASCII_0;
			currentB = b.charAt(i) - ASCII_0;

			basicAdd = currentA + currentB + carry;

			carry = basicAdd / 10;

			basicAdd = basicAdd % 10;
			stillFast.append(basicAdd);

		}
		stillFast.reverse();
		answer = stillFast.toString();
		
		return answer;
	}

	public static String subNums(String a, String b) {
		//ok so after some extensive googling theres something faster than + ?!?!?!
		
		StringBuilder fast = new StringBuilder(b.length());
		
		// Base 10 Compliment Time
		
		int currentA;
		String complimentNum = "";
		boolean firstCompliment = true;
		//Complimenting   Youre Hot
		int saveI = 0;
		int bLength = b.length();
		int tempA = 0;
		
		for (int i = bLength - 1; i >= 0; i--) {
			currentA = a.charAt(i) - ASCII_0;
			tempA = 0;
			if (currentA == 0) {
				fast.append(0);
			} else {
				tempA = 10 - currentA;
				if(tempA >= 10) {
					System.out.println("deez");
				}
				fast.append(tempA);
				firstCompliment = false;
				saveI = i - 1;
				i = 0;
			}
			
		}

		for (int i = saveI; i >= 0; i--) {
			currentA = a.charAt(i) - ASCII_0;
			tempA = 9 - currentA;
			fast.append(tempA);
		}
		fast.reverse();
		complimentNum = fast.toString();
		String answer = addNums(b, complimentNum);
		
		return answer;
	}

	public static boolean biggerNumber(String a, String b) {
		// true = a
		// false = b
		boolean loopControl = true;
		int i = 0;
		boolean toReturn = false;
		while (loopControl) {
			if (i < b.length()) {
				int currentA = a.charAt(i) - ASCII_0;
				int currentB = b.charAt(i) - ASCII_0;

				if (currentA > currentB) {
					loopControl = false;
					toReturn = true;
				} else if (currentA < currentB) {
					loopControl = false;
					toReturn = false;
				}
			} else {
				loopControl = false;
			}
			i++;
		}
		return toReturn;
	}

	public static String removeStartingZeroes(String number) {
		boolean loopControl = true;
		int i = 0;
		while (loopControl) {
			if (number.charAt(0) == '0' && number.length() > 1) {
				number = number.substring(1);
				loopControl = false;
			} else if (number.length() == 1) {
				loopControl = false;
			} else {
				loopControl = false;
			}

			i++;
		}
		return number;
	}

	public static String addZeroes(String number, int zeroes) {
		for (int i = 0; i < zeroes; i++) {
			number = 0 + number;
		}
		return number;
	}
}