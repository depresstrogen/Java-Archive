import java.util.Scanner;

public class Spreadsheet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] sheetString = new String[10][9];
		Integer[][] sheet = new Integer[10][9];
		//input
		for(int i = 0; i < 10; i++) {
			String line = sc.nextLine();
			
			for(int j = 0; j < 8; j++) {
				String cell = line.substring(0, line.indexOf(" "));
				sheetString[i][j] = cell;
				line = line.substring(line.indexOf(" ") + 1);
			}
			sheetString[i][8] = line;
		}
		
		for(int i = 0; i < 10; i++) {

			
			for(int j = 0; j < 9; j++) {
				
				if(isNumber(sheetString[i][j])) {
					sheet[i][j] = Integer.parseInt(sheetString[i][j]);
				}
				
			}
//			System.out.println();
		}
		
		boolean change = true;
		
		while(change) {
			change = false;
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 9; j++) {
					if(sheet[i][j] == null) {
						String cell = sheetString[i][j];
						boolean passed = true;
						boolean done = false;
						int total = 0;
						while(!done) {
							if(cell.indexOf('+') == 0) {
								cell = cell.substring(1);
							}
							
							String comp = cell.substring(0,2);
							cell = cell.substring(2);
							
							
							
							int indexI = comp.charAt(0) - 65;
							int indexJ = comp.charAt(1) - 49;
							
//							System.out.print(comp + indexI + indexJ + "_");
							
							if(sheet[indexI][indexJ] == null) {
								done = true;
								passed = false;
							} else {
								total += sheet[indexI][indexJ];
//								System.out.print(sheet[indexI][indexJ]);
							}
							
							
							if(cell.indexOf('+') != 0) {
								done = true;
							}
							
						}
						if (passed) {
							sheet[i][j] = total;
							change = true;
						}
//						System.out.println();
						
					}
					
				}
			}
		}
		
		//print array
//		for(int i = 0; i < 10; i++) {
//
//			
//			for(int j = 0; j < 9; j++) {
//				
//				System.out.print(sheetString[i][j] + "_");
//				
//			}
//		System.out.println();
//		}
		System.out.println();
		for(int i = 0; i < 10; i++) {

			String line = "";
			for(int j = 0; j < 9; j++) {
				if(sheet[i][j] == null) {
					line += "*" + " ";
				} else {
				line += sheet[i][j] + " ";
				}
				
			}
		System.out.println(line.substring(0, line.length() - 1));
		}

	}
	
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
