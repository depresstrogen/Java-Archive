import java.util.Scanner;

public class Tourny {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = 1;
    int count = 0;
    int group = 0;
    
    while (x <= 6) {
      String input = sc.next();
      char letter = input.charAt(0);
      if (letter == 'W') {
        count = count + 1;
      }
      x ++;
    }
    
    if (count == 1 || count == 2){
      group = 3;
    } else if (count == 3 || count == 4) {
      group = 2;
    } else if (count == 5 || count == 6) {
      group = 1;
    } else {
      group = -1;
    }
    System.out.println(group);
    
  }
}