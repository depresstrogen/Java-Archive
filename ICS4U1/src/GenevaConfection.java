import java.util.Scanner;
import java.util.Stack;
public class GenevaConfection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			boolean possible = false;
			int numCars = sc.nextInt();
			int nextN = 1;
			Stack<Integer> cars = new Stack<Integer>();
			Stack<Integer> branch = new Stack<Integer>();
			Stack<Integer> lake = new Stack<Integer>();
			for (int j = 0; j < numCars; j++) {
				cars.add(sc.nextInt());
			}
			
			boolean loopControl = true;
			
			while(loopControl) {
				if(!cars.empty() && cars.peek() == nextN) {
					lake.add(cars.pop());
					nextN ++;
				} else if (!branch.empty() && branch.peek() == nextN) {
					lake.add(branch.pop());
					nextN ++;
				} else if (cars.empty() && branch.empty()) {
					possible = true;
					loopControl = false;
				} else if (cars.empty()) {
					loopControl = false;
				} else {
					branch.add(cars.pop());
				}
			}
			if (possible) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
	}//main
}//GenevaConfection
