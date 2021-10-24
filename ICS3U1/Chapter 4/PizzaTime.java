import java.util.Scanner;
import java.text.NumberFormat;
public class PizzaTime {
  public static void main(String[] args) {
    NumberFormat money = NumberFormat.getCurrencyInstance();
    Scanner sc = new Scanner(System.in);
    final double LABOUR = 2.00;
    final double RENT = 2.00;
    System.out.println("Enter the diameter of the pizza in inches: ");
    int diameter = sc.nextInt();
    double materials = 0.05 * diameter * diameter;
    System.out.println("The cost of making the pizza is: " + money.format(materials + LABOUR + RENT));
  }
}