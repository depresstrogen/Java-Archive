import java.util.Scanner;

public class MissingNo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x ++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int total = 0;

			for (int i = 1; i <= n; i++) {
				total = n * (n + 1) / 2;
			}
			System.out.println(total);
			
			int difference = total - s;

			int ans = 0;
			int ansCount = 0;
			
			int jx = difference - 1;
			int ix = 1;
			System.out.println(jx + " " + ix + " ");
			
			int ansx = (jx - ix + 1) / 2;
			System.out.println(ansx);
			ansx = difference;


			for (int i = 1; i <= n; i++) {
				for(int j = i; j <= n; j++) {
					if (j + i == difference && j != i) {
						System.out.println(j + " " + i + " ");
						ans = (j - i + 1) / 2;
						
						//System.out.println("  " + ((j + i - 1) / 2));
						ansCount++;
						i = difference + 1;
						j = difference + 1;
						
					}
				}
			}

			
			
			System.out.println(ansx);
		}
	}
}