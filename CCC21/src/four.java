//Arranging Books
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class four {
	public static void main(String[] args) {
		int swapCount = -1;
		boolean stringMessy = true;
		
		String tempString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			tempString = reader.readLine();
	    } catch (Exception e) {
			
		}
		
	    int[] array = new int[tempString.length()];
		for(int i = 0; i < tempString.length(); i++) {
	    	if (tempString.charAt(i) == 'L') {
	    		array[i] = 0;
			}
			if (tempString.charAt(i) == 'M') {
				array[i] = 1;
			}
			if (tempString.charAt(i) == 'S') {
				array[i] = 2;
			}
		}
		
		
//		for(int i = 0; i < array.length; i++) {
//			System.out.print(array[i]);
//		}
//		System.out.println();
		
		int startIndex = 0;
		int endIndex = array.length;
		
		while (stringMessy) {
			boolean ok = true;
			int i = startIndex;
			int section = 0;
			int latestOOS = -1;
			int earliestOOS = -1;
			while (ok) {
				if(i == endIndex) {
					ok = false;
				} else if (array[i] > section) {
					section = array[i];
//					System.out.print(section + " ");
					if (earliestOOS == -1) {
						earliestOOS = i;
					}
				} else if (array[i] < section) {
//					System.out.print(i + " ");
					latestOOS = i;
				}
				i++;
			}
			
			if (latestOOS != -1) {
				int temp = array[latestOOS];
				array[latestOOS] = array[earliestOOS];
				array[earliestOOS] = temp;
				
//				for(int j = 0; j < array.length; j++) {
//					System.out.print(array[j]);
//				}
//				System.out.println();
			} else {
				stringMessy = false;
			}
			
			//Remove solved Pieces
			int indSection = 0;
			for (int j = startIndex; j < endIndex; j++) {
				if (array[j] == indSection) {
					startIndex ++;
				} else {
					break;
				}
			}
			
			indSection = 2;
			for (int j = endIndex - 1; j >= startIndex; j--) {
				if (array[j] == indSection) {
					endIndex --;
				} else {
					break;
				}
			}
			
			swapCount ++;
		}
		System.out.println(swapCount);
	}
}