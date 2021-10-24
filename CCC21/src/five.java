//Modern Art

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class five {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int x = 0;
		int y = 0;
		int n = 0;
		
		int numCol = 0;
		int numRow = 0;
		
		try {
			y = Integer.parseInt(reader.readLine());
			x = Integer.parseInt(reader.readLine());
			n = Integer.parseInt(reader.readLine());
	    } catch (Exception e) {
			
		}

		boolean[] rows = new boolean[y];
		boolean[] cols = new boolean[x];
		
		
		
		for(int i = 0; i < n; i++) {
			String input = "";
			try {
				input = reader.readLine();
//				System.out.print(input);
		    } catch (Exception e) {
				
			}
			
			char type = input.charAt(0);
			int index = Integer.parseInt(input.substring(2));
			
			if (type == 'R') {
				rows[index - 1] = !rows[index - 1];
			}
			
			if (type == 'C') {
				cols[index - 1] = !cols[index - 1];
			}
		}
		
		for(int i = 0; i < rows.length; i++) {
			if(rows[i]) {
				numRow++;
			}
		}
		for(int i = 0; i < cols.length; i++) {
			if(cols[i]) {
				numCol++;
			}
		}
		//System.out.print(numCol + " " + numRow + " ");
		
		System.out.println(((numCol * y) + (numRow * x)) - (numCol * numRow * 2));
		
	}
}