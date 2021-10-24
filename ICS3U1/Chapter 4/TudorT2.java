import java.util.Scanner;

public class TudorT2 {
  public static void main(String[] args) {
    
    // Declaration
    Scanner sc = new Scanner(System.in);
    int count = 0;
    int pearls  = 0;
    String input = "T";
    String lastInput;
    while (count != 7) {
      lastInput = input;
      input = sc.nextLine();
      if (input.equals("J")) {
        if (lastInput.equals("J")) {
          
        } else if (lastInput.equals("T")) {
          pearls ++;
        }
      }
      count ++;
      System.out.println(input);
      System.out.println(lastInput);
    }
    System.out.println(pearls);
  }
}