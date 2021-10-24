import java.util.Scanner;
public class Flipper {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int[][] array = new int[2][2];
	 array[0][0] = 1;
	 array[0][1] = 2;
	 array[1][0] = 3;
	 array[1][1] = 4;
	 int temp = 0;
	 String input = sc.nextLine();
	 for (int i = 0; i < input.length(); i++) {
		 if (input.charAt(i) == 'H') {
			 temp = array[1][0];
			 array[1][0] = array[0][0];
			 array[0][0] = temp;
			 temp = array[1][1];
			 array[1][1] = array[0][1];
			 array[0][1] = temp;
		 } else if (input.charAt(i) == 'V') {
			 temp = array[0][0];
			 array[0][0] = array[0][1];
			 array[0][1] = temp;
			 temp = array[1][0];
			 array[1][0] = array[1][1];
			 array[1][1] = temp;
		 }
	 }
	 System.out.print(array[0][0] + " ");
	 System.out.print(array[0][1]);
	 System.out.println("");
	 System.out.print(array[1][0] + " ");
	 System.out.print(array[1][1]);
 }
}
