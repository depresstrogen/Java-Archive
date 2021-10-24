import java.util.Scanner;
public class change {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int quarters, dimes, nickels;
   System.out.print("Number Of Cents: ");
   int number = sc.nextInt();
   quarters = number / 25;
   number = number % 25;
   dimes = number / 10;
   number = number % 10;
   nickels = number / 5;
   number = number % 5;
   System.out.println("Quarters: " + quarters);
   System.out.println("Dimes: " + dimes);
   System.out.println("Nickels: " + nickels);
   System.out.println("Pennies: " + number);
  }
}