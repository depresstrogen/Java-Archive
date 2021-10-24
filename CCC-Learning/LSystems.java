import java.util.Scanner;
public class LSystems {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r;
		int t;
		String a;
		int repeat;
		int temp = 0;
		String aProgress = "";
		String answer = "";
		for (int z = 0; z < 10; z++) {
			r = sc.nextInt();
			t = sc.nextInt();
			a = sc.next();
			repeat = a.length();
			temp = 0;
			aProgress = "";
			char[] index = new char[r];
			String[] data = new String[r];
			answer = "";
			for (int i = 0; i < r; i++) {
				index[i] = sc.next().charAt(0);
				data[i] = sc.next();
			}
			for (int i = 0; i < t; i++) {
				for (int j = 0; j < repeat; j++) {
					if (a.charAt(j) != ' ' ) {
						temp = a.charAt(j) - 65;
						aProgress = aProgress + data[temp];
					}
				}
				a = aProgress;
				aProgress = "";
				repeat = a.length();
			}
			answer = answer + a.charAt(0) + a.charAt(a.length() - 1);
			System.out.println(answer + " " + a.length());
	}
	}
}