import java.util.Stack;
import java.util.Scanner;
public class TryStack {
	
	public static void main(String[] args) {
		Stack<Integer> brackets = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		boolean isFormed = true;
		
		for(int i = 0; i < input.length(); i++) {
			int currentChar = input.charAt(i);
			
			switch(currentChar) {
			case '(':
			case '{':
			case '[':
				brackets.add(currentChar);
			}
			
			if (currentChar == ')') {
				if (!brackets.empty() && brackets.pop() == '(') {
				} else {
					isFormed = false;
					i = input.length();
				}
			} else if (!brackets.empty() && currentChar == '}') {
				if (brackets.pop() == '{') {
				} else {
					isFormed = false;
					i = input.length();
				}
			} else if (!brackets.empty() && currentChar == ']') {
				if (brackets.pop() == '[') {
				} else {
					isFormed = false;
					i = input.length();
				}
			}
		}
		
		if(isFormed) {
			input += " is well-formed";
		} else {
			input += " is not well-formed";
		}
		
		System.out.print(input);

	}//main

}//TryStack
