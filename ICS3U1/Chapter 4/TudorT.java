import java.util.Scanner;

public class TudorT {
  public static void main(String[] args) {
    
    // Declaration
    Scanner sc = new Scanner(System.in);
    int count = 0;
    int pearls  = 0;
    int inputbutworse;
    while (count != 5) {
      String input = sc.nextLine();
     
      if (input.equals("P")) {
        pearls ++;
      }
      count ++;
    }
    System.out.println(pearls);
  }
}