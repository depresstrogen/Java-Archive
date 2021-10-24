import java.util.Scanner;

public class WhenRome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loopy = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < loopy; i++) {
			String input = sc.nextLine();
			String romA = input.substring(0, input.indexOf('+'));
			String romB = input.substring(input.indexOf('+') + 1, input.length() - 1);

			int a = romanDecrypt(romA);
			int b = romanDecrypt(romB);
			// System.out.println(romanEncrypt(a) + " TO " + a);
			// System.out.println(romanEncrypt(b) + " TO " + b);
			// System.out.println(a + b + " TO " + romanEncrypt(a + b));
			
//	Only 1000 is limiting
//			if (a + b <= 1000) {
				System.out.println(input + romanEncrypt(a + b));
//			} else {
//				System.out.println(input + "CONCORDIA CUM VERITATE");
//			}
		}
	}

	public static String romanEncrypt(int num) {
		String roman = "";

		while (num > 0) {
			if (num - 1000 >= 0) {
				roman += "M";
				num -= 1000;
			} else if (num - 900 >= 0) {
				roman += "CM";
				num -= 900;
			} else if (num - 500 >= 0) {
				roman += "D";
				num -= 500;
			} else if (num - 400 >= 0) {
				roman += "CD";
				num -= 400;
			} else if (num - 100 >= 0) {
				roman += "C";
				num -= 100;
			} else if (num - 90 >= 0) {
				roman += "XC";
				num -= 90;
			} else if (num - 50 >= 0) {
				roman += "L";
				num -= 90;
			} else if (num - 40 >= 0) {
				roman += "XL";
				num -= 40;
			} else if (num - 10 >= 0) {
				roman += "X";
				num -= 10;
			} else if (num - 9 >= 0) {
				roman += "IX";
				num -= 9;
			} else if (num - 5 >= 0) {
				roman += "V";
				num -= 5;
			} else if (num - 4 >= 0) {
				roman += "IV";
				num -= 4;
			} else if (num - 1 >= 0) {
				roman += "I";
				num -= 1;
			}
		}
		return roman;
	}

	public static int romanDecrypt(String roman) {
		int num = 0;
		final int nM = 1000;
		final int nD = 500;
		final int nC = 100;
		final int nL = 50;
		final int nX = 10;
		final int nV = 5;
		final int nI = 1;
		String mPlace;
		String dPlace;
		String cPlace;
		String lPlace;
		String xPlace;
		String vPlace;
		String iPlace;
		// M
		while (roman.indexOf('M') != -1) {
			num += nM;
			mPlace = roman.substring(0, roman.indexOf('M'));

			if (mPlace.indexOf('C') != -1) {
				num -= nC;
			}

			roman = roman.substring(roman.indexOf('M') + 1);
		}

		// System.out.println(roman);

		// D
		while (roman.indexOf('D') != -1) {
			num += nD;
			dPlace = roman.substring(0, roman.indexOf('D'));

			if (dPlace.indexOf('C') != -1) {
				num -= nC;
			}

			roman = roman.substring(roman.indexOf('D') + 1);
		}

		// System.out.println(roman);

		// C
		while (roman.indexOf('C') != -1) {
			num += nC;
			cPlace = roman.substring(0, roman.indexOf('C'));

			if (cPlace.indexOf('X') != -1) {
				num -= nX;
			}

			roman = roman.substring(roman.indexOf('C') + 1);
		}

		// System.out.println(roman);

		// L
		while (roman.indexOf('L') != -1) {
			num += nL;
			lPlace = roman.substring(0, roman.indexOf('L'));

			if (lPlace.indexOf('X') != -1) {
				num -= nX;
			}

			roman = roman.substring(roman.indexOf('L') + 1);
		}

		// System.out.println(roman);

		// X
		while (roman.indexOf('X') != -1) {
			num += nX;
			xPlace = roman.substring(0, roman.indexOf('X'));

			if (xPlace.indexOf('I') != -1) {
				num -= nI;
			}

			roman = roman.substring(roman.indexOf('X') + 1);
		}

		// System.out.println(roman);

		// V
		while (roman.indexOf('V') != -1) {
			num += nV;
			vPlace = roman.substring(0, roman.indexOf('V'));

			if (vPlace.indexOf('I') != -1) {
				num -= nI;
			}

			roman = roman.substring(roman.indexOf('V') + 1);
		}

		// System.out.println(roman);

		// I
		while (roman.indexOf('I') != -1) {
			num += nI;
			iPlace = roman.substring(0, roman.indexOf('I'));
			roman = roman.substring(roman.indexOf('I') + 1);
		}

		// System.out.println(roman);

		return num;
	}

}
