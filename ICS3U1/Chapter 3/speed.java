import java.util.Scanner;
import java.lang.Number;

public class speed {
  public static void main(String[] args) {
    int value = 0;
    Scanner sc = new Scanner(System.in);
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    if (numa >= numb) {
      System.out.println("Congratulations, you are within the speed limit!");
    } else {
        int coolassvar = numb - numa;
        if (coolassvar <= 20) {
          value = 100;
        } else if (coolassvar <= 30) {
          value = 270;
        } else {
          value = 500;
        }
        System.out.println("You are speeding and your fine is $" + value + ".");
      }
  }
}