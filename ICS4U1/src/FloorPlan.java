import java.util.*;
public class FloorPlan {
	static final char WALL = 'I';
	static final char FLOOR = '.';
	static char[][] room;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tiles = sc.nextInt();
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int roomsFilled = 0;
		ArrayList<Integer> roomSizes = new ArrayList<Integer>();
		sc.nextLine();
		room = new char[rows][cols];
		String temp = "";

		for (int i = 0; i < rows; i++) {
			temp = sc.nextLine();
			for (int j = 0; j < cols; j++) {
				room[i][j] = temp.charAt(j);
			}
		}
		
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				if (room[row][col] == FLOOR) {
					roomSizes.add(countRoom(row, col));
				}
			}
		}
		//ArrayList sorting so easy
		Collections.sort(roomSizes);
		//So its decending
		Collections.reverse(roomSizes);
		
		for(int i = 0; i < roomSizes.size(); i ++) {
			if (tiles - roomSizes.get(i) >= 0) {
				tiles -= roomSizes.get(i);
				roomsFilled ++;
			} else {
				i = roomSizes.size();
			}
		}
		if (roomsFilled == 1) {
			System.out.println(roomsFilled + " room, " + tiles + " square metre(s) left over");
		} else {
			System.out.println(roomsFilled + " rooms, " + tiles + " square metre(s) left over");
		}
	}

	public static int countRoom(int row, int col) {
		int count = 1;
		room[row][col] = WALL;
		// North Check
		if (col - 1 >= 0 && room[row][col - 1] == FLOOR) {
			count += countRoom(row, col - 1);
		}
		// east
		if (row + 1 < room.length && room[row + 1][col] == FLOOR) {
			count += countRoom(row + 1, col);
		}
		// south
		if (col + 1 < room[row].length && room[row][col + 1] == FLOOR) {
			count += countRoom(row, col + 1);
		}
		// west
		if (row - 1 >= 0 && room[row - 1][col] == FLOOR) {
			count += countRoom(row - 1, col);
		}

		// since this a non-void method, there will be a return statement in both base
		// and recursive cases
		// return 0 if the row or col reference is off the slide
		// otherwise return 1 + recursive calls east, south, west and north
		return count;
	}
}
