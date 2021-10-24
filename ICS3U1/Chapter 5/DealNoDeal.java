import java.util.Arrays;
import java.util.Scanner;
public class DealNoDeal {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0, input, sum = 0, dealer, avg;
    int numCases = sc.nextInt();
    int [] boxes = new int[] {0, 100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000};
    while (numCases > count) {
      input = sc.nextInt();
      boxes[input] = 0;
      count ++;
    }
    count = 0;
    for (int i = 0; i < 11; i++) {
      sum = sum + boxes[count];
      count ++;
    }
    dealer = sc.nextInt();
    avg = sum / (10 - numCases);
    if (avg < dealer) {
      System.out.println("deal");
    } else {
      System.out.println("no deal");
    }
  }
}