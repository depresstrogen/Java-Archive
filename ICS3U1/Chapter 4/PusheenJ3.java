import java.util.Scanner;
public class PusheenJ3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int num = sc.nextInt();
    String line = "";
    int count2 = 1;
    int count = 0;
    boolean right = false;
    int sashimi, nigiri, budget;
    while (count < num) {
      line = "NO";
      right = false;
      sashimi = sc.nextInt();
      nigiri = sc.nextInt();
      budget = sc.nextInt();
      if (sashimi == budget || nigiri == budget || (sashimi + nigiri) == budget) {
        line = "YES";
      } if (budget % sashimi + budget / sashimi == 0 && sashimi < budget) {
        line = "YES";
      }
      while (sashimi * count2 <= budget) {
        if (sashimi * count2 == budget) {
          right = true;
        } else {
          right = false; 
        }
        count2 ++;
      }
      if (right == true) {
        line = "YES";
      }
        System.out.println(line);
        count ++;
      
    }
  }// Main
}// Class