/**
 * @author Riley Power
 * @version November 24 2020
 */
import java.util.Scanner;

public class NumberCounts {
	public static void main(String[] args) {
		int grades[] = new int[43];
		grades[41] = 4;
		int i = 0;
		for(int element : grades) {
			i ++;
			element += 5;
			System.out.println(element + " " + grades[i]);
		}
		
	}
}
