import java.util.Scanner;

public class Spirals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c;
		for (c = 0; c < n; c++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int totalNums = (y - x);

			int[][] spiral = new int[12][12];

			int curX = 5;
			int curY = 5;
			

			char dir = 'D';
			spiral[curX][curY] = x;

			for (int i = 1; i <= totalNums; i++) {
				int curNum = i + x;

				if (dir == 'D') {
					if (spiral[curX + 1][curY + 1] == 0) {
						dir = 'R';
						curX++;
					} else {
						curX++;
					}
				} else if (dir == 'R') {
					if (spiral[curX - 1][curY + 1] == 0) {
						dir = 'U';
						curY++;
					} else {
						curY++;
					}
				} else if (dir == 'U') {
					if (spiral[curX - 1][curY - 1] == 0) {
						dir = 'L';
						curX--;
					} else {
						curX--;
					}
				} else if (dir == 'L') {
					if (spiral[curX + 1][curY - 1] == 0) {
						dir = 'D';
						curY--;
					} else {
						curY--;
					}
				}

				spiral[curX][curY] = curNum;

			}

			int[] lineLengths = new int[spiral.length];
			boolean[] rowHas = new boolean[spiral.length];
			int[] rowHasJ = new int[spiral.length];
			for (int i = 0; i < spiral.length; i++) {
				for (int j = 0; j < spiral[i].length; j++) {
					if (spiral[i][j] == 0) {

					} else if (Integer.toString(spiral[i][j]).length() > lineLengths[j]) {
						lineLengths[j] = Integer.toString(spiral[i][j]).length();
						rowHas[i] = true;
					}
				}
			}
			
			for (int i = 0; i < spiral.length; i++) {
				int temp = 0;
				for (int j = 0; j < spiral[i].length; j++) {
					temp += spiral[i][j];
				}
				rowHasJ[i] = temp;
			}
			

//		for (int j = 0; j < lineLengths.length; j++) {
//			System.out.print(rowHasJ[j]);
//		}
//		System.out.println();
			boolean loopy = true;
			int ctrl = 0;

			int firstLine = 0;
			while (loopy) {
				if (lineLengths[ctrl] > 0) {
					firstLine = ctrl;
					loopy = false;
				}
				ctrl++;
			}

			boolean printed = false;

			for (int i = 1; i < spiral.length - 1; i++) {
				for (int j = 0; j < spiral[i].length; j++) {
					if (spiral[i][j] == 0 && lineLengths[j] > 0 && spiral[i][j + 1] != 0) {
						// System.out.print("x");
						for (int k = 0; k < lineLengths[j]; k++) {
							System.out.print(" ");
						}
					} else if (spiral[i][j] == 0 && lineLengths[j] > 0 && spiral[i + 1][j] != 0 && rowHas[i] == true) {
						for (int k = 0; k < lineLengths[j]; k++) {
							System.out.print(" ");
						}
						System.out.print(" ");
					} else if (spiral[i][j] == 0 && spiral[i - 1][j] != 0 && rowHasJ[i] != 0) {
						for (int k = 0; k < lineLengths[j]; k++) {
							System.out.print(" ");
						}
						System.out.print(" ");
					} else if (spiral[i][j] == 0) {

					} else {
						int numSpaces = Integer.toString(spiral[i][j]).length();

						for (int k = numSpaces; k < lineLengths[j]; k++) {
							System.out.print(" ");
						}
						if (j > firstLine) {
							System.out.print(" " + spiral[i][j]);
						} else {
							System.out.print(spiral[i][j]);
						}

						printed = true;
					}
				}
				if (printed) {
					System.out.println();
				}
				printed = false;
			}
		}
		if(c < n-1) {
			System.out.println();
		}
	}
}
