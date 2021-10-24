import java.util.Scanner;

public class TowerHanoi {
	static int moves;
	public static void main(String[] args) {
		moves = 0;
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		moveTower(height,1,3);
		System.out.println("Moves: " + moves);
	}
	public static void moveTower(int height, int start, int finish) {
		moves ++;
		if(height == 1) {
			System.out.println(start + " --> " + finish);
		} else {
			int other = 6 - (start + finish);
			moveTower(height - 1, start, other);
			System.out.println(start + " --> " + finish);
			moveTower(height - 1, other, finish);
		}
	}
}
