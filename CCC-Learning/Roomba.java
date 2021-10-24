import java.util.Scanner;
public class Roomba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int count = 0;
		
		int[][] roombas = new int[n][2];
		int[][] server = new int [m][2];
		
		for(int i = 0; i < n; i++) {
			roombas[i][0] = sc.nextInt();
			roombas[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			server[i][0] = sc.nextInt();
			server[i][1] = sc.nextInt();
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(roombas[i][0] >= server[j][0]
					&& server[j][1] >= roombas[i][1]) {
						count ++;
						//System.out.println(server[j][0] + " " + server[j][1] + " . " + roombas[i][0] + " " + roombas[i][1]);
					}
				}
			}
		
		System.out.println(count);
	}
}
